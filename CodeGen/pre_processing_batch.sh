#!/bin/bash
#SBATCH --job-name=git_train
#SBATCH -o output_pre_processing.txt
#SBATCH -e error_pre_processing.txt
#SBATCH -p gypsum-titanx
#SBATCH --gres=gpu:1
#SBATCH --mem=240000
#SBATCH --array=2
module load conda
conda activate transCoder_env
python -m codegen_sources.preprocessing.preprocess /work/pi_adrozdov_umass_edu/transLRPL/final_dataset/train_dataset_json --langs csharp ruby --mode=monolingual --local=True --bpe_mode=fast --train_splits=1