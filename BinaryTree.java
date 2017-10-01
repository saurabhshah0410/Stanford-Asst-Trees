public class BinaryTree {
	public Node root;
	public class Node {
		public Node left;
		public Node right;
		public int data;
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
		if(key < node.data) 
			node.left = insert(node.left,key);
		else if (key >= node.data)
			node.right = insert(node.right,key);
		return(node) ;
	}
	public void build123() 
	{
		BinaryTree();
		this.insert(1);
		this.insert(2);
		this.insert(3);
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
		if(size(node.left) <= size(node.right)) return size(node.right) + 1;
		else return size(node.left) + 1;
	}
	public int minValue() 
	{
		return minValue(root);
	}
	private int minValue(Node node)
	{
		if(node.left == null)
		 return node.data;
		return minValue(node.left);
	}
	public int maxValue()
	{
		return maxValue(root);
	}
	private int maxValue(Node node)
	{
		if(node.right == null) return node.data;
		else return maxValue(node.right);
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
			int temp = sum-node.data;
			return(hasPathSum(node.left,temp) || hasPathSum(node.right,temp));
		}
	}
	public void printPaths()
	{
		int[] path = new int[this.size()];
		printPathsRecur(root,path,0);
	}
	private void printPathsRecur(Node node,int[] path,int pathlen)
	{
		if(node == null) return;
		path[pathlen++] = node.data;
		if(node.left == null && node.right == null) 
		{
			for(int i = 0;i < pathlen;i++)
			{	
				System.out.println(path[i]);
			}
		}
		else 
		{
			printPathsRecur(node.left,path,pathlen);
			printPathsRecur(node.right,path,pathlen);
		}	
	}
	public void mirror()
	{
		mirror(root);
	}
	private void mirror(Node node)
	{
		if(node == null) return;
		{
			mirror(node.left);
			mirror(node.right);
			Node temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
		
	}
	public void doubleTree()
	{
		doubleTree(root);
	}
	private void doubleTree(Node node)
	{
		if(node == null) return;
		Node temp;
		doubleTree(node.left);
		doubleTree(node.right);
		if(node == null) return;
		temp = node.left;
		node.left = new Node(node.data);
		node.left.left = temp;
	}
	public boolean sameTree(Node other)
	{
		return sameTree(root,other);
	}
	private boolean sameTree(Node node1,Node node2)
	{
		if(node1 == null && node2 != null) return false;
		if(node1 != null && node2 == null) return false;
		if(node1 == null && node2 == null) return true;
		if(node1.data != node2.data) return false;
		return (sameTree(node1.left,node2.left) && sameTree(node1.right,node2.right));
	
	}
	public static int countTrees(int N) //static because it can be called without refering to the class
	//Not my algo. Saw it from the solutions. Mine was very very long 
		{
		if(N <= 1)
			return 1;
		else
		{
		int count = 0;
		int left_trees;
		int right_trees;
		int possible_node;
		for(possible_node = 1;possible_node <= N;possible_node++)
		{
			left_trees = countTrees(possible_node-1);
			right_trees = countTrees(N-possible_node);
			count += left_trees*right_trees;
		}
		return count;
		}
	}
	public boolean isBST()
	{
		return isBST(root);
	}
	private boolean isBST(Node node)
	{
		if(node == null)
			return true;
		if(minValue(node) > maxValue(node))
			return false;
		if(node.left != null && maxValue(node.left) > node.data)
			return false;
		if(node.right != null && minValue(node.right) < node.data)
			return true;
		return isBST(node.left) && isBST(node.right); 			
			
	}
	public boolean isBST2() //couldn't figure this out too. All other were more or less my own algos
	{
		return isBST2(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	private boolean isBST2(Node node,int min,int max)
	{
		if(node == null)
			return true;
		if(min >= max) 
			return false;
		boolean left = isBST2(node,min,node.data);
		if(!left) return false;
		boolean right = isBST2(node,node.data+1,max);
		return right;
	}
}
















