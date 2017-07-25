
public class BinaryTree {
	private Node root;
	private class Node {
		private Node left;
		private Node right;
		private int data;
		public Node(int newData) {
			data = newData;
			left = null;
			right = null;
		}
	}
	public void BinaryTree() {
		root = null;
	}
	public boolean lookUp(int key) {
		return lookUp(root,key);
	}
	private boolean lookUp(Node node,int key) {
		if(node == null) return false;
		if(node.data == key) return true;
		else if(node.data < key) return lookUp(node.right,key);
		else return lookUp(node.left,key);
	}
	public void insert(int key){
		root = insert(root,key);
	}
	private Node insert(Node node,int key){
		if(node == null) return new Node(key);
		if(node.data <= key) 
			node.left = insert(node.left,key);
		else if (node.data > key)
			node.right = insert(node.right,key);
		return(node) ;
	}
	public void build123() 
	{
		BinaryTree();
		root = insert(root,2);
		root = insert(root,1);
		root = insert(root,3);
	}
}













