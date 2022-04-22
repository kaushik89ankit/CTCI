public class Tree {
	TreeNode root;

	public Tree() {
		root = null;
	}


	void printPostOrder(TreeNode root) {

		if (root == null) {
			return;
		}

		printPostOrder(root.left);

		printPostOrder(root.right);

		System.out.println(root.data);

	}

	void printInorder(TreeNode node) {
		if (node == null)
			return;

		/* first recur on left child */
		printInorder(node.left);

		/* then print the data of node */
		System.out.println(node.data + " ");

		/* now recur on right child */
		printInorder(node.right);
	}

	void printPreorder(TreeNode node) {
		if (node == null)
			return;

		/* first print data of node */
		System.out.println(node.data + " ");

		/* then recur on left sutree */
		printPreorder(node.left);

		/* now recur on right subtree */
		printPreorder(node.right);
	}

	public static void main(String[] args) {

		Tree tree = new Tree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		System.out.println("Post Order :");
		tree.printPostOrder(tree.root);
		System.out.println("In order");
		tree.printInorder(tree.root);
		System.out.println("Pre Order :");
		tree.printPreorder(tree.root);
	}
}