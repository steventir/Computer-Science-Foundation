/**
  * This represents a single node in a binary tree
  **/
public class Node {

	int data;
	Node left;
	Node right;

	public Node(int data, Node lNode, Node rNode) {
		this.data = data;
		left = lNode;
		right = rNode;
	}
	
	public static void main(String[] args) {
		
		//      5
		//	  /	  \
		//   3     1
		//  / \   / \
		// 8   nil   nil
		Node root = new Node(5, new Node(3, new Node(8,null,null), null), new Node(1, null, null));

		System.out.print("Pre Order Traversal: ");
		preOrderTraversal(root); // Should print 5 3 8 1
		System.out.println();

		System.out.print("In Order Traversal: ");
		inOrderTraversal(root); // Should print 8 3 5 1 
		System.out.println();

		System.out.print("Post Order Traversal: ");
		postOrderTraversal(root); //Should print 8 3 1 5
		System.out.println();
	}

	public static void preOrderTraversal(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}

	public static void inOrderTraversal(Node root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.print(root.data + " ");
			inOrderTraversal(root.right);
		}
	}

	public static void postOrderTraversal(Node root) {
		if (root != null) {
			inOrderTraversal(root.left);
			inOrderTraversal(root.right);
			System.out.print(root.data + " ");
		}
	}
}
