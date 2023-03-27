import os
import shutil

src_dir = "/work/pi_adrozdov_umass_edu/transLRPL/dataset1"
dest_dir = "/work/pi_adrozdov_umass_edu/transLRPL/dataset2"

for name1 in os.scandir(src_dir):
    if name1.is_dir():
        empty = False
        for name2 in os.scandir(name1.path):
            if len(os.listdir(name2.path)) == 0:
                empty = True
        
        if not empty:
            print("Copying " + name1.name + " directory")
            shutil.copytree(name1.path, dest_dir + "/" + name1.name)