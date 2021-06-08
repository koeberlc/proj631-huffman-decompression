package main_program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <b>Class Node</b>
 * 
 * <p>Global method related to nodes</p>
 *
 */
public class Node implements Comparable<Node> {
	private String label;
	private Integer frequence;
	private Node left_child = null;
	private Node right_child = null;
	private String value = null;
	
	/**
	 * @param label (<i>type: String</i>): label of the node
	 * @param frequence (<i>type: int</i>): frequency of the character related to the node
	 * 
	 * <p>Constructeur</p>
	 */
	public Node(String label, Integer frequence) {
		super();
		this.label = label;
		this.frequence = frequence;
	}
	
	/**
	 * @param label (<i>type: String</i>): label of the node
	 * @param frequence (<i>type: int</i>): frequency of the character related to the node
	 * @param node (<i>type: Node</i>): left child to the current node
	 * 
	 * <p>Constructeur</p>
	 * 
	 */
	public Node(String label, Integer frequence, Node node) {
		super();
		this.label = label;
		this.frequence = frequence;
		this.left_child = node;
	}
	
	/**
	 * @param label (<i>type: String</i>): label of the node
	 * @param frequence (<i>type: int</i>): frequency of the character related to the node
	 * @param left_node (<i>type: Node</i>): left child to the current node
	 * @param right_node (<i>type: Node</i>): right child to the current node
	 * 
	 * <p>Constructeur</p>
	 */
	public Node(String label, Integer frequence, Node left_node, Node right_node) {
		super();
		this.label = label;
		this.frequence = frequence;
		this.left_child = left_node;
		this.right_child = right_node;
	}

	/**
	 * @return label (<i>type: String</i>)
	 * 
	 * <p>Label getter</p>
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @param label (<i>type: String</i>)
	 * 
	 * <p>Label setter</p>
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/**
	 * @return frequence (<i>type: int</i>)
	 * 
	 * <p>frequence getter</p>
	 */
	public Integer getFrequence() {
		return frequence;
	}
	/**
	 * @param frequence (<i>type: int</i>)
	 * 
	 * <p>frequence setter</p>
	 */
	public void setFrequence(Integer frequence) {
		this.frequence = frequence;
	}
	/**
	 * @return left_child (<i>type: Node</i>)
	 * 
	 * <p>left_child getter</p>
	 */
	public Node getLeftChild() {
		return left_child;
	}
	/**
	 * @param left_node (<i>type: Node</i>)
	 * 
	 * <p>left_child setter</p>
	 */
	public void setLeftChild(Node left_node) {
		this.left_child = left_node;
	}
	/**
	 * @return right_child (<i>type: Node</i>)
	 * 
	 * <p>right_child getter</p>
	 */
	public Node getRightChild() {
		return right_child;
	}
	/**
	 * @param right_node (<i>type: Node</i>)
	 * 
	 * <p>right_child setter</p>
	 */
	public void setRightChild(Node right_node) {
		this.right_child = right_node;
	}
	/**
	 * @return value (<i>type: String</i>)
	 * 
	 * <p>value getter</p>
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value (<i>type: String</i>)
	 * 
	 * <p>value setter</p>
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	
	/**
	 * @return res (<i>type: String</i>): result
	 * 
	 * <p>Diplay the tree using the prefix method</p>
	 */
	public String getListPrefixe() {
		String res = "";
		Node node = this;
		
		if(node != null) {
			res = node.getLabel() + " " + node.getFrequence() + " | " + node.getListPrefixe(node.getLeftChild()) + node.getListPrefixe(node.getRightChild());
		}
		return res;
	}
	public String getListPrefixe(Node node) {
		String res = "";
		
		if(node != null) {
			res = node.getLabel() + " " + node.getFrequence() + " | " + node.getListPrefixe(node.getLeftChild()) + node.getListPrefixe(node.getRightChild());
		}
		return res;
	}
	
	/**
	 * @return <i>type: boolean</i>
	 * 
	 * <p>Return if the current node is a leaf (doesn't have any child)</p>
	 */
	public boolean isLeaf() {
		return this.getRightChild() == null && this.getRightChild() == null;
	}
	/**
	 * @return list_node (<i>type: List<\Node></i>): list of node object
	 * 
	 * Return the list of all nodes lower than the current one
	 */
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
	
	/**
	 * @return list_leaf (<i>type: List<\Node></i>): list of node object
	 * 
	 * Return the list of all leaf nodes lower than the current one
	 */
	public List<Node> getAllLeaf(){
		List<Node>list_leaf = new ArrayList<Node>();
		List<Node>list_node = this.getAllNode();
		for(Node n : list_node) {
			if(n.isLeaf()) {
				list_leaf.add(n);
			}
		}
		return list_leaf;
	}
	
	/**
	 * @param node (<i>type: Node</i>): node object target
	 * @return path (<i>type: List<\Node></i>): list of node object
	 * 
	 * Return the list of the path of each from the current node to the node passed in parameter
	 */
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
		
	
	@Override
    public int compareTo(Node o) {
        return this.getFrequence().compareTo(o.getFrequence());
    }

	@Override
	public String toString() {
		return label + " " + frequence;
	}
	
}
