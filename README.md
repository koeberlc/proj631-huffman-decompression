# proj631-huffman-decompression

Developpement project for the PROJ631 : project gestion.

In this project, I develop an Huffman algorithme that decompress a text related to a lexicon and a binary text.


# How to use :
You need to place a binary compressed file.txt in the text/compressed folder and the lexicon in the text/lexicon folder.
Then just change the filename in the main.java to select your file and finally you can execute it.

At the end of the programm you can see the orignal text base on your selected file.



# Structure :
_main_program folder :_
All files related to the different classes

_text/lexicon folder :_
All the lexicon text files linked to a compressed text
Each file contains the number of different characters and each character linked to its frequency

_text/text_to_convert folder :_
All the text files we want to convert

_text/text_converted folder :_
All the bin files containing the compressed texts

_unittest folder :_
Unit Test for the project.
