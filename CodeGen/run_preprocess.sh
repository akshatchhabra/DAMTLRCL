#!/bin/bash
#SBATCH --job-name=preprocess
#SBATCH -o output_preprocess.txt
#SBATCH -e error_preprocess.txt
#SBATCH -p gypsum-titanx
#SBATCH --gres=gpu:1
#SBATCH --mem=240000
#SBATCH --array=2

module load conda
conda activate transCoder_env
python -m codegen_sources.preprocessing.preprocess ../../dataset/train_dataset_json --langs csharp ruby --mode monolingual --bpe_mode=fast --local=True --train_splits=1