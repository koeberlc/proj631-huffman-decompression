package main_program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Node {
	private String label;
	private String frequence;
	private Node left_child = null;
	private Node right_child = null;
	private Float value = null;
	
	public Node(String label, String frequence) {
		super();
		this.label = label;
		this.frequence = frequence;
	}
	
	public Node(String label, String frequence, Node node) {
		super();
		this.label = label;
		this.frequence = frequence;
		this.left_child = node;
	}
	
	public Node(String label, String frequence, Node left_node, Node right_node) {
		super();
		this.label = label;
		this.frequence = frequence;
		this.left_child = left_node;
		this.right_child = right_node;
	}

	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getFrequence() {
		return frequence;
	}
	public void setFrequence(String frequence) {
		this.frequence = frequence;
	}
	public Node getLeftChild() {
		return left_child;
	}
	public void setLeftChild(Node left_node) {
		this.left_child = left_node;
	}
	public Node getRightChild() {
		return right_child;
	}
	public void setRightChild(Node right_node) {
		this.right_child = right_node;
	}
	public Float getValue() {
		return value;
	}
	public void setValue(Float value) {
		this.value = value;
	}

	public boolean isLeaf() {
		return this.getRightChild() == null && this.getRightChild() == null;
	}
	public List<Node> getAllNode(){
		List<Node>list_node = new ArrayList<Node>();
		list_node.add(this);
		if(!this.isLeaf()) {
			if(this.getRightChild() != null) {
				list_node.addAll(this.getRightChild().getAllNode());
			}
			list_node.addAll(this.getLeftChild().getAllNode());
		}
		return list_node;
		
	}
	public List<Node> getAllLeaf(){
		List<Node>list_leaf = new ArrayList<Node>();
		List<Node>list_node = this.getAllNode();
		for(Node n : list_node) {
			if(n.isLeaf()) {
				list_leaf.add(n);
			}
		}
		return list_node;
	}
	public List<Node> getPath(Node node){
		List<Node>path = new ArrayList<Node>();
		List<Node>list_node = this.getAllNode();
		while(this != node){
			for(Node n : list_node) {
				if(n.getLeftChild() == node || n.getRightChild() == node) {
					path.add(node);
					node = n;
				}
			}
		}
		path.add(this);
		Collections.reverse(path);
		return path;
	}
		
	
	
}
