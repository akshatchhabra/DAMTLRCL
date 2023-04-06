import os
import shutil
import json

num_languages = 2
json_data = "/work/pi_adrozdov_umass_edu/transLRPL/json_dataset"
num_problems = len([file for file in os.listdir(json_data) if os.path.isfile(os.path.join(json_data, file))])/num_languages
print(num_problems)

train_split = 0.8
num_train_problems = round(train_split*num_problems)
train_dataset_path = "/work/pi_adrozdov_umass_edu/transLRPL/final_dataset/train_dataset_json"
test_dataset1_path = "/work/pi_adrozdov_umass_edu/transLRPL/final_dataset/test_datasets_json/test_dataset1"
test_dataset2_path = "/work/pi_adrozdov_umass_edu/transLRPL/final_dataset/test_datasets_json/test_dataset2"

train_submission_split = 0.7

try:
    for probCount, json_file in enumerate(os.scandir(json_data)):
        if json_file.is_file():
            
            file_name = json_file.name
            split_file_name = file_name.split("_")
            if len(split_file_name) > 1:
                problem_id = split_file_name[0][1:]
                lang = split_file_name[1].split(".")[0]
                if lang == "C#":
                    language = "csharp"
                elif lang == "C++":
                    language = "cpp"
                else:
                    language = lang.lower()
                new_file_name = language + "." + problem_id + ".json"
                file_name = new_file_name

            if probCount < num_train_problems*num_languages:
                with open(json_file.path, 'r') as input_file:
                    train_file_name = file_name
                    test1_file_name = file_name

                    with open(train_dataset_path + "/" + train_file_name, 'w') as train_file, \
                        open(test_dataset1_path + "/" + test1_file_name, 'w') as test1_file:

                        submissions = input_file.readlines()
                        num_submissions = len(submissions)

                        num_train_submissions = round(train_submission_split*num_submissions)

                        for subCount, submission in enumerate(submissions):
                            if subCount < num_train_submissions:
                                json.dump(json.loads(submission), train_file)
                                train_file.write('\n')
                            else:
                                json.dump(json.loads(submission), test1_file)
                                test1_file.write('\n')

            else:
                test2_file_name = file_name
                shutil.copy(json_file.path, test_dataset2_path + "/" + test2_file_name)

except Exception as e:
    print("Error occured")
    print(e)