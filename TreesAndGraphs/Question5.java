/*

Problem : Validate BST: Implement a function to check if a binary tree is a binary search tree


*/


class Question5 {

	static Integer lastValue = null;

	static boolean isBSTInOrder(TreeNode node) {

		if (node == null) {
			return true;
		}


		if (!isBSTInOrder(node.left)) {
			return false;
		}

		if (lastValue != null && node.data <= lastValue) {
			return false;
		}

		lastValue = node.data;

		if (!isBSTInOrder(node.right)) {
			return false;
		}

		return true;

	}

	static boolean isBSTMinMax(TreeNode node) {


		return checkMinMaxBST(node , Integer.MIN_VALUE , Integer.MAX_VALUE);


	}

	static boolean checkMinMaxBST(TreeNode node , Integer min , Integer max) {

		if (node == null) return true;

		if (node.data > max || node.data <= min)return false;

		return checkMinMaxBST(node.left , min , node.data) && checkMinMaxBST(node.right , node.data , max);
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


		System.out.println("Is the given tree BST ? " + isBSTInOrder(node2));

		System.out.println("Is the given tree BST via MinMax? " + isBSTMinMax(node2));
	}

}