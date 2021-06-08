package main_program;

import java.util.*;

/**
 * <b>Class Huffman</b>
 * 
 * <p>Decode a binary file into a text file using a lexicon</p>
 *
 */
public class Huffman {
	/**
	 * @param filename (<i>type: String</i>): the file name to decompress
	 * 
	 * <p>This method is use to decompress a file, it calls many other methods in order to obtain a text file containing the original text</p>
	 */
	public void decompress(String filename){
		String path = "src/text/";
		FileFunction file_compressed = new FileFunction(path + "compressed/" + filename + ".txt");
		FileFunction file_original = new FileFunction(path + "original/" + filename + ".txt");
		FileFunction file_lexicon = new FileFunction(path + "lexicon/" + filename + ".txt");
		
		String text_compressed = file_compressed.FileReader();
		String text_lexicon = file_lexicon.FileReader();
		
		Frequency frequence = new Frequency(file_lexicon);
		
		Node root = this.makeTree(frequence.getFrequencyDict());
		
		String result = this.getOriginalText(root, text_compressed);
		
        
        file_original.FileWriter(result);
        System.out.println(result);
	}
	
	
	/**
	 * @param FrequencyDict (<i>type: List<\String></i>): Contains a list of string composed of a letter and its frequency in the original text
	 * @return root (<i>type: Node</i>): returns the root of the tree
	 * 
	 * <p>This method is used to form a tree based on a list of character and their frequency. Each node can have a left and a right child initialized with the value 0 or 1.</p>
	 */
	public Node makeTree(List<String> FrequencyDict) {
		List<Node>list_node = new ArrayList<Node>();

		for(String v:FrequencyDict) {
			
			list_node.add(new Node(v.substring(0,1),Integer.parseInt(v.substring(2))));
		}

		while(list_node.size() > 1) {
			Collections.sort(list_node);
			Node n0 = list_node.get(0);
			Node n1 = list_node.get(1);
			
			Node current_node = new Node(null, n0.getFrequence() + n1.getFrequence(), n0,n1);
			
			list_node.remove(0);
			list_node.remove(0);
			list_node.add(current_node);
			//System.out.println(list_node);
			
		}
		
		Node root = list_node.get(0);
		
		this.setValues(root);
		return root;
		
	}
	
	/**
	 * @param node (<i>type: Node</i>)
	 * 
	 * <p>This method assign the value 0 or 1 to the left or right child of the node passed in parameter.</p>
	 */
	public void setValues(Node node) {
		Node l_child = node.getLeftChild();
		Node r_child = node.getRightChild();
		
		if(l_child!=null) {
			l_child.setValue("0");
			this.setValues(l_child);
		}
		if(r_child!=null) {
			r_child.setValue("1");
			this.setValues(r_child);
		}
	}
	
	/**
	 * @param root (<i>type: Node</i>): Root of the tree
	 * @param text_compressed (<i>type: String</i>): Compressed text in binary
	 * @return result (<i>type: String</i>): Returns the original text
	 * 
	 * <p>This method used the tree nodes to get the character related to binary character list</p>
	 */
	public String getOriginalText(Node root, String text_compressed) {
		String result = "";
        
		Node current = root;
        for(int i = 0; i < text_compressed.length(); i++) {
        	char c = text_compressed.charAt(i);
        	if (current.isLeaf()) {
                result += current.getLabel();
                current = root;
            }
        	if (c == "0".charAt(0)){
                current = current.getLeftChild();;  
                
            } else {
                current = current.getRightChild();
            }

        }
        
        if (current.isLeaf()) {
            result += current.getLabel();
            current = root;
        }
        return result;
	}
}
