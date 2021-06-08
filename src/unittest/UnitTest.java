package unittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main_program.FileFunction;
import main_program.Frequency;
import main_program.Huffman;
import main_program.Node;

class UnitTest {

	@Test
	public void testFrequency() {
		FileFunction f = new FileFunction("src/text/lexicon/bonjour.txt");
		Frequency frequence = new Frequency(f);
		
		assertEquals(frequence.getFrequencyDict().toString(), "[b 1, n 1, j 1, u 1, r 1, o 2, ! 2]");
	}
	
	@Test
	public void testnbChar() {
		FileFunction f = new FileFunction("src/text/lexicon/bonjour.txt");
		Frequency frequence = new Frequency(f);
		
		assertEquals(frequence.getNbChar(), 9);
	}
	
	@Test
	public void testTreePrefix() {
		Huffman h = new Huffman();
		FileFunction file = new FileFunction("src/text/lexicon/bonjour.txt");
		Frequency frequence = new Frequency(file);
		
		Node root = h.makeTree(frequence.getFrequencyDict());
		
		assertEquals(root.getListPrefixe(), "null 9 | null 4 | ! 2 | null 2 | b 1 | n 1 | null 5 | null 2 | j 1 | u 1 | null 3 | r 1 | o 2 | ");
	}
	
	@Test
	public void testOriginalText() {
		Huffman h = new Huffman();
		FileFunction file_l = new FileFunction("src/text/lexicon/bonjour.txt");
		FileFunction file_c = new FileFunction("src/text/compressed/bonjour.txt");
		Frequency frequence = new Frequency(file_l);
		
		String text_compressed = file_c.FileReader();
		Node root = h.makeTree(frequence.getFrequencyDict());
		String result = h.getOriginalText(root, text_compressed);

		assertEquals(result, "bonjour!!");
	}
	
	

}
