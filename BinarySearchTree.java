package study;

public class BinarySearchTree {

	private BSTNode root = null;   		//you can't call a function in a BSTNode class if there is no node to make the call
	private int [] A;					//holds all the values within the tree but sorted
	private int i;
	
	
	
	public int count() {				//if empty
		
		if(isEmpty())	return 0;
		else			return root.count();													//if(root == null) 
		
	}
	
	
	
	public int height() {
		
		if(isEmpty()) return 0;
		else 		  return root.height();
	}
	
	
	public void insert(int value) {
		
		if(isEmpty()) root = new BSTNode(value);
		
		else		  root.insert(value);
		
	}
	
	
	public boolean isEmpty() { return root == null;}

	public void inOrder() {							  //if empty
		
		if(!isEmpty()) { 	
		A = new int[count()];
		i = 0;
		root.inOrder();					
		}
	}
	
	public class BSTNode{		
		
		int x;
		BSTNode left = null;
		BSTNode right = null;
		
		public BSTNode(int x) {
			
			this.x =x;
		}
		
		public int count() {							//if there is at least one node in the tree
			
			int c = 1;									//assumption that there is already a node in BST
														//recursive calls
			if(left != null)	c += left.count();		//checking if there is a left subtree then adding the recursive values to c
			
			if(right != null)	c += right.count();		//checking if there is a right subtree then adding the recursive values to c
			
			return c;
		}
		
		public int height() {
			int hl = 0;
			int hr = 0;
			
			if(left != null) hl = left.height();
			if(right != null) hr = right.height();
			
			return max(hl,hr);
		}
		
		public int max(int a, int b) {
			
			if(a >= b) return a;
			else 	   return max(b,a);
		}
	
		public void inOrder() {
			
			if(left != null) left.inOrder();
			
			A[i++] = x;
			
			if(right != null) right.inOrder();
		}
		
		public int min() {
			
			if(left != null) left.min();
			
			return left.x;
		}
		
		public int max() {
			
			if(right != null) right.min();
			
			return right.x;
		}
	
		public void insert(int value) {
			
			if(value < x)	if(left != null)	left.insert(value);
			
			else 						  		left = new BSTNode(value);
			
			if(value > x)	if(right != null)	right.insert(value);
			
			else								right = new BSTNode(value);
			
		}
		
	}
	
	
	
	
}
