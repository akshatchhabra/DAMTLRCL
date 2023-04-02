#!/bin/bash
#SBATCH --job-name=git_train
#SBATCH -o output_preprocess1_dataset.txt
#SBATCH -e error_preprocess1_dataset.txt
#SBATCH -p gypsum-titanx
#SBATCH --gres=gpu:1
#SBATCH --mem=240000
#SBATCH --array=2
./project_codenet_aggregate.sh