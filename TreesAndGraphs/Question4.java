/*

Problem : Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
node never differ by more than one.


*/


class Question4 {

	static int getHeight(TreeNode node) {

		if (node == null) {
			return 0;
		}

		int leftNodeHeight = getHeight(node.left);
		int rightNodeHeight = getHeight(node.right);

		if (leftNodeHeight == Integer.MIN_VALUE || rightNodeHeight == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}


		if (Math.abs(leftNodeHeight - rightNodeHeight) > 1) {
			return Integer.MIN_VALUE;
		}

		return Math.max(leftNodeHeight, rightNodeHeight) + 1;
	}

	public static void main(String[] args) {

		TreeNode node2 = new TreeNode(2);
		TreeNode node0 = new TreeNode(0);
		TreeNode node3 = new TreeNode(3);
		TreeNode node1 = new TreeNode(1);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);


		node2.left = node0;
		node2.right = node3;
		node0.left = node1;
		node0.right = node4;
		node3.left = node5;


		System.out.println("Is binary tree balanced ? " + (getHeight(node2) != Integer.MIN_VALUE));
	}
}