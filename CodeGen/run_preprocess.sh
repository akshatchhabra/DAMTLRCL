#!/bin/bash
#SBATCH --job-name=preprocess
#SBATCH -o output_preprocess_bt.txt
#SBATCH -e error_preprocess_bt.txt
#SBATCH -p gypsum-titanx
#SBATCH --gres=gpu:1
#SBATCH --mem=240000
#SBATCH --array=2

module load conda
conda activate transCoder_env
python -m codegen_sources.preprocessing.preprocess /work/pi_adrozdov_umass_edu/akshatchhabr_umass_edu/dataset/dataset_cpp_csharp_full_DA --langs cpp csharp --mode monolingual --bpe_mode=fast --local=True --train_splits=1