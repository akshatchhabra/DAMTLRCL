# Copyright (c) 2019-present, Facebook, Inc.
# All rights reserved.
#
# This source code is licensed under the license found in the
# LICENSE file in the root directory of this source tree.
#

from codegen_sources.preprocessing.lang_processors.tree_sitter_processor import (
    TreeSitterLangProcessor
)
from codegen_sources.preprocessing.lang_processors.tokenization_utils import (
    ind_iter
)

IDENTIFIERS = {"identifier", "field_identifier"}

RUBY_TOKEN2CHAR =  {"STOKEN00": "#",
    "STOKEN01": "=begin",
    "STOKEN02": "=end",
    "STOKEN03": "\\n",
    "STOKEN04": "\\r",
    }
RUBY_CHAR2TOKEN =  {value: " " + key + " " for key, value in RUBY_TOKEN2CHAR.items()}

class RubyProcessor(TreeSitterLangProcessor):
    def __init__(self, root_folder):
        super().__init__(
            language="ruby",
            ast_nodes_type_string=["comment", "string", "bare_string", "character"],
            stokens_to_chars=RUBY_TOKEN2CHAR,
            chars_to_stokens=RUBY_CHAR2TOKEN,
            root_folder=root_folder,
        )

    def extract_functions(self, tokenized_code):
        """Extract functions from tokenized Ruby code"""
        if isinstance(tokenized_code, str):
            tokens = tokenized_code.split()
        else:
            assert isinstance(tokenized_code, list)
            tokens = tokenized_code
        i = ind_iter(len(tokens))
        functions_standalone = []
        functions_class = []
        return functions_standalone, functions_class
