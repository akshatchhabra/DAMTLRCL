import os
import json

data_dir = "/work/pi_adrozdov_umass_edu/transLRPL/dataset2"
output_file = "/work/pi_adrozdov_umass_edu/transLRPL/json_dataset"

for problem in os.scandir(data_dir):
    if problem.is_dir():
        for language in os.scandir(problem.path):
            file_name = problem.name + "_" + language.name + ".json"
            with open(output_file + "/" + file_name, 'w') as outfile:
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
                        # print(entry)

                        json.dump(entry, outfile)
                        outfile.write('\n')
        print(problem.name + " done")