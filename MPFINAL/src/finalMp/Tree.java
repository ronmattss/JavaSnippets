package finalMp;
// Supporting class for MP7
public class Tree {
	String k = "^";

	public class Node {
		int key;
		String keyS;
		Node left;
		Node right;

		public Node(String item) {
			keyS = item;
			left = right = null;
		}

	}

	public Node root;

	Tree() {
		root = null;
	}

	void insert(String key) {
		root = insertRec(root, key);
	}

	public void insert(String key, String rootKey, int n, int counter) {
		root = insertRecs(root, key, rootKey, n,counter);
	}

	Node insertRec(Node root, String key) {
		/* If the tree is empty, return a new node */
		if (root == null && key != k ) {
			root = new Node(key);
			return root;
		}

		int i = key.compareToIgnoreCase(root.keyS);
		// System.out.println(i);
		if (i <= -1 && key != k)
			root.left = insertRec(root.left, key);
		else if (i >= 1 && key != k)
			root.right = insertRec(root.right, key);

		/* return the (unchanged) node pointer */
		return root;

	}
	
	Node insertRecs(Node root, String key, String rootKey, int n,int counter) {
		Node temp = Search(root, key);
		
		  if (key.compareToIgnoreCase(k) == 0) return root;
		// if root == keyRoot proceed
		// else keep recursing 
		if (root == null && counter == 0 ) {
			root = new Node(key);
			return root;
		}
		if(root == null && counter != 0)
		{return root;			
		}
		
		
		if(root.left != null && rootKey.compareToIgnoreCase(root.left.keyS) == 0)
		{
			if(n == 1)
			{
				root.left.left = new Node(key);
				return root;
			}
			else if(n == 2)
			{
				root.left.right = new Node(key);
				return root;
			}
			else
				return root;
		}	
		
		else if(root.right != null && rootKey.compareToIgnoreCase(root.right.keyS) == 0  )
		{
			if(n == 1)
			{
				root.right.left = new Node(key);
				return root;
			}
			else if(n == 2)
			{
				root.right.right = new Node(key);
				return root;
			}
			else
				return root;
		}	
		

		else if(rootKey.compareToIgnoreCase(root.keyS) != 0)
		{
			root.left = insertRecs(root.left,key,rootKey,n,counter);
			
			root.right = insertRecs(root.right,key,rootKey,n,counter);
		}
		else if (rootKey.compareToIgnoreCase(root.keyS) != 0)
		{
			root.right = insertRecs(root.right,key,rootKey,n,counter);
		}
		
		else if (rootKey.compareToIgnoreCase(root.keyS) == 0)
		{
			if(n == 1)
			{
				root.left = new Node(key);
			}
			else if(n == 2)
			{
				root.right = new Node(key);
			}
		}
		
		else if ( root.left == null)
		{
			return root;
		}
		
		else if ( root.right == null)
		{
			return root;
		}		
		else
		{
			return root;
		}



		/*
		 * if (n == 1 && key != k && root.left == null) { if (key.compareToIgnoreCase(k)
		 * == 0) { key = ""; return root; }
		 * 
		 * root.left = insertRecs(root.left, key, rootKey, n); } else if (n == 2 && key
		 * != k && root.right == null) { System.out.println("fckRi");
		 * 
		 * if (key.compareToIgnoreCase(k) == 0) { System.out.println("f"); key = "";
		 * return root; }
		 * 
		 * root.right = insertRecs(root.right, key, rootKey, n); }
		 */
		/* return the (unchanged) node pointer */
		return root;

	}

	Node Search(Node root, String key) {
		if (root != null) {
			if (key.compareToIgnoreCase(root.keyS) == 0) {
				return root;
			} else {
				Node fN = Search(root.left, key);
				if (fN == null) {
					fN = Search(root.right, key);
				}
				return fN;
			}
		} else {
			return root;
		}

	}

	/*
	 * 
	 * Search(root.left, key); if (key.compareToIgnoreCase(root.keyS) == 0) return
	 * root; Search(root.right, key); if (key.compareToIgnoreCase(root.keyS) == 0)
	 * return root; }
	 */
	public void inorder() {
		System.out.println("Root: " + root.keyS);
		inorderTraversal(root);
	}

	void inorderTraversal(Node root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.print(root.keyS);
			inorderTraversal(root.right);
		}

	}

	Node inorderTraversalSearch(Node root, String rootKey) {
		if (root.keyS.compareToIgnoreCase(rootKey) == 0) {
			return root;
		} else {
			root = inorderTraversalSearch(root.left, rootKey);
			root = inorderTraversalSearch(root.right, rootKey);
		}

		return root;

	}

	public void preOrder() {
		preOrderTraversal(root);
	}

	void preOrderTraversal(Node root) {
		if (root != null) {
			System.out.print(root.keyS);
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}

	public void postOrder() {
		postOrderTraversal(root);
	}

	void postOrderTraversal(Node root) {
		if (root != null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.keyS);
		}
	}

	public static void main(String args[]) {

		Tree t = new Tree();
		t.insert("D");
		t.insert("M");
		t.insert("A");
		t.insert("C");
		t.insert("Z");
		t.inorder();
		System.out.println("");
		t.preOrder();
		System.out.println("");
		t.postOrder();
	}

}

/*
 * switch(n) { case 0: if(root.keyS == key) { System.out.println("same"); }
 * break; case 1: if(key != "!") { root.left = insertRecs(root.left,key,n);
 * return root; } break; case 2: if(key != "!") { root.right =
 * insertRecs(root.right,key,n); return root; }
 * 
 * }
 * 
 * 
 * return root;
 * 
 */
