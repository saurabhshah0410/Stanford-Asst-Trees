
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
	public int size() 
	{
		return size(root);
	}
	private int size(Node node)
	{
		if(node == null) return 0;
		return size(node.left) + size(node.right) + 1;
	}
	public int maxDepth() 
	{
		return maxDepth(root);
	}
	private int maxDepth(Node node) 
	{
		int count;
		if(size(node.left) <= size(node.right)) return size(node.right) + 1;
		else return size(node.left) + 1;
	}
	public int minValue() 
	{
		return minValue(root);
	}
	private int minValue(Node node)
	{
		if(node.left == null) return node.data;
		return minValue(node.left);
	}
	public void printTree() 
	{
		printTree(root);
	}
	private void printTree(Node node)
	{
		if(node == null) return;
		printTree(node.left);
		System.out.println(node.data+ " ");
		printTree(node.right);
	}
	public void printPostOrder() 
	{
		printPostOrder(root);
	}
	private void printPostOrder(Node node) 
	{
		if(node == null) return;
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.println(node.data + " ");
	}
	public boolean hasPathSum(int sum) 
	{
		return hasPathSum(root,sum);
	}
	private boolean hasPathSum(Node node,int sum)
	{
		if(node == null) return sum == 0;
		else
		{
			int subsum = sum-node.data;
			return(hasPathSum(node.left,subsum) || hasPathSum(node.right,subsum));
		}
	}
	public void printPaths()
	{
		int[] path = new int[1000];
		printPathsRecur(root,path,0);
	}
	private void printPathsRecur(Node node,int[] path,int pathlen)
	{
		if(node == null) return;
		path[pathlen++] = node.data;
		if(node.left == null && node.right == null) 
		{
			printArray(path,pathlen);
		}
		else 
		{
			printPathsRecur(node.left,path,pathlen);
			printPathsRecur(node.right,path,pathlen);
		}	
	}
	private void printArray(int[] array,int pathlen)
	{
		for(int i = 0;i < pathlen;i++)
		{
			System.out.println(array[i]);
		}
		System.out.println();
	}
	public void mirror()
	{
		mirror(root);
	}
	private void mirror(Node node)
	{
		if(node != null) 
		{
			mirror(node.left);
			mirror(node.right);
			Node temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
		
	}
}













