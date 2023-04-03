#!/bin/bash
#SBATCH --job-name=git_train
#SBATCH -o output_install_env.txt
#SBATCH -e error_install_env.txt
#SBATCH -p gypsum-titanx
#SBATCH --gres=gpu:1
#SBATCH --mem=240000
#SBATCH --array=2
./install_env.sh