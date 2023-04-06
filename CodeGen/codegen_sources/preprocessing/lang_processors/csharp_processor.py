# Copyright (c) 2019-present, Facebook, Inc.
# All rights reserved.
#
# This source code is licensed under the license found in the
# LICENSE file in the root directory of this source tree.
#
from codegen_sources.preprocessing.lang_processors.tree_sitter_processor import (
    TreeSitterLangProcessor,
    NEW_LINE,
)
from codegen_sources.preprocessing.lang_processors.java_processor import (
    JAVA_TOKEN2CHAR,
    JAVA_CHAR2TOKEN,
)
from codegen_sources.preprocessing.lang_processors.tokenization_utils import (
    ind_iter,
    NEWLINE_TOKEN,
)
import re

CSHARP_TOKEN2CHAR = JAVA_TOKEN2CHAR.copy()
CSHARP_CHAR2TOKEN = JAVA_CHAR2TOKEN.copy()


class CSharpProcessor(TreeSitterLangProcessor):
    def __init__(self, root_folder):
        super().__init__(
            language="c-sharp",
            ast_nodes_type_string=[
                "comment",
                "string_literal",
                "character_literal",
                "verbatim_string_literal",
                "raw_string_literal"
            ],
            stokens_to_chars=CSHARP_TOKEN2CHAR,
            chars_to_stokens=CSHARP_CHAR2TOKEN,
            root_folder=root_folder,
        )

    # def obfuscate_code(self, code):
    #     res, dico = javalang_obfuscator.obfuscate(code)
    #     return res, dico_to_string(dico)

    # only used when using monolingual-function mode
    def extract_functions(self, tokenized_code):
        """Extract functions from tokenized C# code"""
        if isinstance(tokenized_code, str):
            tokens = tokenized_code.split()
        else:
            assert isinstance(tokenized_code, list)
            tokens = tokenized_code
        i = ind_iter(len(tokens))
        functions_standalone = []
        functions_class = []
        try:
            token = tokens[i.i]
        except KeyboardInterrupt:
            raise
        except:
            return [], []
        while True:
            try:
                # detect function
                tokens_no_newline = []
                index = i.i
                while index < len(tokens) and len(tokens_no_newline) < 3:
                    index += 1
                    if tokens[index].startswith(NEWLINE_TOKEN):
                        continue
                    tokens_no_newline.append(tokens[index])

                if token == ")" and (
                    tokens_no_newline[0] == "{"
                    or (
                        tokens_no_newline[0] == "throws" and tokens_no_newline[2] == "{"
                    )
                ):
                    # go previous until the start of function
                    while token not in [";", "}", "{", "*/", "ENDCOM", NEW_LINE, "\n"]:
                        i.prev()
                        token = tokens[i.i]

                    if token == "*/":
                        while token != "/*":
                            i.prev()
                            token = tokens[i.i]
                        function = [token]
                        while token != "*/":
                            i.next()
                            token = tokens[i.i]
                            function.append(token)
                    elif token == "ENDCOM":
                        while token != "//":
                            i.prev()
                            token = tokens[i.i]
                        function = [token]
                        while token != "ENDCOM":
                            i.next()
                            token = tokens[i.i]
                            function.append(token)
                    else:
                        i.next()
                        token = tokens[i.i]
                        function = [token]

                    while token != "{":
                        i.next()
                        token = tokens[i.i]
                        function.append(token)
                    if token == "{":
                        number_indent = 1
                        while not (token == "}" and number_indent == 0):
                            try:
                                i.next()
                                token = tokens[i.i]
                                if token == "{":
                                    number_indent += 1
                                elif token == "}":
                                    number_indent -= 1
                                function.append(token)
                            except StopIteration:
                                break
                        if "static" in function[0 : function.index("{")]:
                            functions_standalone.append(
                                self.remove_annotation(" ".join(function))
                            )
                        else:
                            functions_class.append(
                                self.remove_annotation(" ".join(function))
                            )
                i.next()
                token = tokens[i.i]
            except KeyboardInterrupt:
                raise
            except:
                break
        return functions_standalone, functions_class

    # modify for C#
    # def remove_annotation(self, function):
    #     return re.sub(
    #         r"^@ (Override|Deprecated|SuppressWarnings) (\( .*? \) )", "", function
    #     )

    def get_function_name(self, function):
        return self.get_first_token_before_first_parenthesis(function)

    def extract_arguments(self, function):
        return self.extract_arguments_using_parentheses(function)
