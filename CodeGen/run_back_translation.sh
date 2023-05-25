#!/bin/bash
#SBATCH --job-name=backtranslation
#SBATCH -o output_back_translation.txt
#SBATCH -e error_back_translation.txt
#SBATCH -p gypsum-titanx
#SBATCH -n 1
#SBATCH --gres=gpu:1
#SBATCH --mem=240000
#SBATCH --array=2

module load conda
conda activate transCoder_env
module load cuda/11.7.0
python /work/pi_adrozdov_umass_edu/akshatchhabr_umass_edu/TransLRPL/CodeGen/run_CodeT5_gpu.py