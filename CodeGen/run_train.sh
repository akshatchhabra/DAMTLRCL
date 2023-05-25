#!/bin/bash
#SBATCH --job-name=preprocess
#SBATCH -o output_mlm_cpp_csharp_mapped_DA.txt
#SBATCH -e error_mlm_cpp_csharp_mapped_DA.txt
#SBATCH -p gypsum-titanx
#SBATCH -n 1
#SBATCH --gres=gpu:1
#SBATCH --mem=24000
#SBATCH --array=2

module load conda
conda activate transCoder_env
module load cuda/11.7.0
# from scratch
# python codegen_sources/model/train.py \
# --exp_name mlm \
# --dump_path '/work/pi_adrozdov_umass_edu/transLRPL/dataset_cpp_csharp/cpp_csharp_mlm_scratch_dump' \
# --data_path '/work/pi_adrozdov_umass_edu/transLRPL/dataset_cpp_csharp/train_dataset_json/XLM-syml' \
# --split_data_accross_gpu local \
# --mlm_steps 'csharp_monolingual,cpp_monolingual' \
# --add_eof_to_stream true \
# --word_mask_keep_rand '0.8,0.1,0.1' \
# --word_pred '0.15' \
# --encoder_only true \
# --n_layers 6  \
# --emb_dim 1024  \
# --n_heads 8  \
# --lgs 'csharp_monolingual-cpp_monolingual' \
# --max_vocab 64000 \
# --gelu_activation false \
# --roberta_mode false \
# --amp 2  \
# --fp16 true  \
# --batch_size 32 \
# --bptt 512 \
# --epoch_size 100000 \
# --max_epoch 100000 \
# --split_data_accross_gpu global \
# --optimizer 'adam_inverse_sqrt,warmup_updates=10000,lr=0.0001,weight_decay=0.01' \
# --save_periodic 0 \
# --validation_metrics _valid_mlm_ppl \
# --stopping_criterion '_valid_mlm_ppl,20'

# with reload and 2 languages
python codegen_sources/model/train.py \
--exp_name mlm \
--dump_path '/work/pi_adrozdov_umass_edu/akshatchhabr_umass_edu/dataset/dataset_cpp_csharp_full_DA' \
--data_path '/work/pi_adrozdov_umass_edu/akshatchhabr_umass_edu/dataset/dataset_cpp_csharp_full_DA/XLM-syml' \
--split_data_accross_gpu local \
--mlm_steps 'cpp_monolingual,csharp_monolingual' \
--add_eof_to_stream true \
--word_mask_keep_rand '0.8,0.1,0.1' \
--word_pred '0.15' \
--encoder_only false \
--n_layers 0 \
--n_layers_encoder 6 \
--n_layers_decoder 6 \
--emb_dim 1024 \
--n_heads 8 \
--lgs 'cpp_monolingual-csharp_monolingual' \
--max_vocab 64000 \
--gelu_activation false \
--roberta_mode false \
--reload_model 'TransCoder_model_1.pth,TransCoder_model_1.pth' \
--reload_encoder_for_decoder true \
--lgs_mapping 'cpp_monolingual:cpp_sa'  \
--amp 2 \
--fp16 true \
--batch_size 32 \
--bptt 512 \
--epoch_size 50000 \
--max_epoch 100000 \
--split_data_accross_gpu global \
--optimizer 'adam_inverse_sqrt,warmup_updates=10000,lr=0.0001,weight_decay=0.01' \
--save_periodic 0 \
--validation_metrics _valid_mlm_ppl \
--stopping_criterion '_valid_mlm_ppl,50'