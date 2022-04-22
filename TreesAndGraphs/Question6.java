/*

Problem : Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
binary search tree. You may assume that each node has a link to its parent.


*/


class Question5 {


	static TreeNode findInOrderSuccessor(TreeNode node) {


		if (node == null) return null;

		if (node.right != null) {
			return findMin(node.right);
		}


		TreeNode parent = node.parent;

		while (parent != null && parent.left != node) {
			node = parent;
			parent = parent.parent;
		}

		return parent;

	}


	static TreeNode findMin(TreeNode node) {

		if (node.left != null) {
			node = node.left;
		}

		return node;
	}



	public static void main(String[] args) {

	}
}



// Space Complexity : O(1)

// Time Complexity : O(logn)