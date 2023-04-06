#!/bin/bash
#SBATCH --job-name=git_train
#SBATCH -o ./output/output_preprocess4_dataset.txt
#SBATCH -e ./output/error_preprocess4_dataset.txt
#SBATCH -p gypsum-titanx
#SBATCH --gres=gpu:1
#SBATCH --mem=240000
#SBATCH --array=2
python3 preprocess4_split_dataset.py