#!/bin/bash
#SBATCH --job-name=git_train
#SBATCH -o output_preprocess3_dataset.txt
#SBATCH -e error_preprocess3_dataset.txt
#SBATCH -p gypsum-titanx
#SBATCH --gres=gpu:1
#SBATCH --mem=240000
#SBATCH --array=2
python3 preprocess3_convert_data_to_json.py