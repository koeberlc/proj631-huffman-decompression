package main_program;

import java.util.*;

public class Huffman {
	public void decompress(String filename){
		String path = "src/text/";
		FileFunction file_compressed = new FileFunction(path + "compressed/" + filename + ".txt");
		FileFunction file_not_compressed = new FileFunction(path + "original/" + filename + ".txt");
		FileFunction file_lexicon = new FileFunction(path + "lexicon/" + filename + ".txt");
		
		String text_compressed = file_compressed.FileReader();
		String text_lexicon = file_lexicon.FileReader();
		
		Frequency frequence = new Frequency(file_lexicon);
		
		
		Node root = this.makeTree(frequence.getFrequencyDict());
		
		
		String result = "";
        
		Node current = root;
        for(int i = 0; i < text_compressed.length(); i++) {
        	char c = text_compressed.charAt(i);
        	if (c == "1".charAt(0)){
                System.out.println("droit " + current);
                current = current.getRightChild();
            } else {
                System.out.println("gauche " + current);
                current = current.getLeftChild();;  
            }
        	
        	if (current.isLeaf()) {
                result += current.getLabel();
                current = root;
            }
        	
        }
        System.out.println(result);
		
		
	}
	
	
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
			System.out.println(list_node);
			
		}
		
		Node root = list_node.get(0);
		
		this.setValues(root);
		return root;
		
	}
	
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
}
