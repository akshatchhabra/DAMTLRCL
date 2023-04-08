import os
import shutil
import json

src_dir = "/work/pi_adrozdov_umass_edu/transLRPL/CodeNet_dataset_pre_processing/Project_CodeNet/data"
base_dir = "/work/pi_adrozdov_umass_edu/transLRPL/dataset_java_csharp"
languages = ["C#", "Java"]
# src_dir = "/work/pi_adrozdov_umass_edu/transLRPL/CodeNet_dataset_pre_processing/Mini_PC/data"
# base_dir = "/work/pi_adrozdov_umass_edu/transLRPL/mini_jc"
# languages = ["C++", "Java"]
dest1_dir = base_dir + "/dataset1"

if not os.path.isdir(base_dir):
    os.mkdir(base_dir)
if not os.path.isdir(dest1_dir):
    os.mkdir(dest1_dir)
    
for problem in os.scandir(src_dir):
    if problem.is_dir():
        all_langs_present = True
        for language in languages:
            if not os.path.isdir(problem.path + "/" + language):
                all_langs_present = False

        if all_langs_present == True:
            problem_directory = dest1_dir + "/" + problem.name
            os.mkdir(problem_directory)
            for language in languages:
                language_directory = problem.path + "/" + language
                target_language_directory = problem_directory + "/" + language
                shutil.copytree(language_directory, target_language_directory)


dest2_dir = base_dir + "/json_dataset"
if not os.path.isdir(dest2_dir):
    os.mkdir(dest2_dir)
print("Second step of preprocessing - converting to json started")

for problem in os.scandir(dest1_dir):
    if problem.is_dir():
        for language in os.scandir(problem.path):
            file_name = problem.name + "_" + language.name + ".json"
            with open(dest2_dir + "/" + file_name, 'w') as outfile:
                for submission in os.scandir(language.path):
                    if submission.is_file():
                        entry = {"repo_name": "", "path": "", "language": "", "content":""}

                        entry["repo_name"] = problem.name + '/' + language.name + "/" + submission.name
                        entry["path"] = submission.path
                        entry["language"] = language.name

                        submission_file = open(submission.path, "r")
                        submission_content = submission_file.read()
                        submission_file.close()
                        entry["content"] = submission_content

                        json.dump(entry, outfile)
                        outfile.write('\n')

print("Second step of preprocessing - converting to json done")

print("Third step of preprocessing - splitting dataset started")

num_languages = 2
num_problems = len([file for file in os.listdir(dest2_dir) if os.path.isfile(os.path.join(dest2_dir, file))])/num_languages
print(num_problems)

train_split = 0.8
num_train_problems = round(train_split*num_problems)
train_dataset_path = base_dir + "/train_dataset_json"
test_base_dir = base_dir + "/test_datasets_json"
test_dataset1_path = test_base_dir + "/test_dataset1"
test_dataset2_path = test_base_dir + "/test_dataset2"

train_submission_split = 0.7


if not os.path.isdir(train_dataset_path):
    os.mkdir(train_dataset_path)
if not os.path.isdir(test_base_dir):
    os.mkdir(test_base_dir)
if not os.path.isdir(test_dataset1_path):
    os.mkdir(test_dataset1_path)
if not os.path.isdir(test_dataset2_path):
    os.mkdir(test_dataset2_path)

try:
    for probCount, json_file in enumerate(os.scandir(dest2_dir)):
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

    print("Third step of preprocessing - splitting dataset done")

except Exception as e:
    print("Error occured")
    print(e)