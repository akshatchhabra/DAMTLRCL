import os
import logging


path = "/work/pi_adrozdov_umass_edu/akshatchhabr_umass_edu/dataset/dataset_cpp_csharp_full_DA/"

# split into c# and C++ lists
cs_files = []
cpp_files = []
for filename in os.listdir(path):
    if "csharp" in filename and filename.endswith(".json"):
        cs_files.append(filename)
    elif "cpp" in filename and filename.endswith(".json"):
        cpp_files.append(filename)

logging.getLogger().setLevel(logging.INFO)
logging.info(f"number of C# json files: {len(cs_files)}")
logging.info(f"number of C++ json files: {len(cpp_files)}")

num_cs_files = 0
num_cpp_files = 0
for file in cs_files:
    with open(path + file, 'r') as json_file:
        json_list = list(json_file)
        num_cs_files += len(json_list)

for file in cpp_files:
    with open(path + file, 'r') as json_file:
        json_list = list(json_file)
        num_cpp_files += len(json_list)

print(f"number of C# code files: {num_cs_files}")
print(f"number of C++ code files: {num_cpp_files}")

