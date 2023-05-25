from transformers import RobertaTokenizer, T5ForConditionalGeneration
import os
import json
import logging
import torch

def backtranslate(text, tokenizer, model, back_model):
    input_ids = tokenizer(text, return_tensors="pt").input_ids.to(device)

    generated_ids = model.generate(input_ids, max_new_tokens = 512)

    # convert generated ids to text, tokenize the text pass the tokenized text to java-cs model
    mid_text = tokenizer.decode(generated_ids[0].cpu(), skip_special_tokens=True)
    to_text_input_ids = tokenizer(mid_text, return_tensors="pt").input_ids.to(device)
    to_text_generated_ids = back_model.generate(to_text_input_ids, max_new_tokens = 512)
    
    # print 
    final_text = tokenizer.decode(to_text_generated_ids[0].cpu(), skip_special_tokens=True)
    
    return final_text
    # this prints: "Convert a SVG string to a QImage."

device = "cuda:0" if torch.cuda.is_available() else "cpu"
print(device)
logging.getLogger().setLevel(logging.INFO)
path = "/work/pi_adrozdov_umass_edu/akshatchhabr_umass_edu/dataset/dataset_cpp_csharp_full_DA/"
back_translation_percentage = 0.1
# file_num = 5000
file_num = 6644

tokenizer = RobertaTokenizer.from_pretrained('Salesforce/codet5-base')
model = T5ForConditionalGeneration.from_pretrained('Salesforce/codet5-base-codexglue-translate-cs-java').to(device)
back_model =  T5ForConditionalGeneration.from_pretrained('Salesforce/codet5-base-codexglue-translate-java-cs').to(device)

cs_files = []
for filename in os.listdir(path):
    if "csharp" in filename and filename.endswith(".json"):
        cs_files.append(filename)

logging.info(f"found {len(cs_files)} JSON files")
logging.info("======= Back-translation =======")
logging.info(f"Back-translating {back_translation_percentage*100}% samples in each JSON file")

# continue from file 2241
continue_index = cs_files.index("csharp.02659.json")
cs_files = cs_files[continue_index:]

# exclude files beyond 5000
end_index = cs_files.index("csharp.05000.json")
cs_files = cs_files[:end_index]

logging.info(torch.cuda.memory_summary(device=None, abbreviated=False))

for file in cs_files:
    logging.info(f"back translating {file}")
    with open(path + file, 'r') as json_file:
        json_list = list(json_file)
        num_translate = int(len(json_list)*back_translation_percentage)
        logging.info(f"translating {num_translate} code files")
        json_list = json_list[:num_translate]
        da_list = []
        for json_obj in json_list:
            try:
                json_obj = json.loads(json_obj)
                # print(type(json_obj))
                # print(f"Original Object: {json_obj}")
                
                json_obj['content'] = backtranslate(json_obj['content'], tokenizer, model, back_model)
                
                json_obj['repo_name'] = json_obj['repo_name'] + "_DA"
                da_list.append(json_obj)
            except Exception as e :
                logging.info(f"error occured for {json_obj['repo_name']}")
            # print(f"After Data Augmentation: {json_obj}")
        if len(da_list) > 0:
            with open(path + f"csharp.0{file_num}.json", 'a') as da_file:
                for i in range(len(da_list)):
                    if i == len(da_list) - 1:
                        da_file.write(json.dumps(da_list[i]))
                    else:
                        da_file.write(json.dumps(da_list[i]) + "\n")
    file_num += 1


