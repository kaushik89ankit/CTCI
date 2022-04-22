/*

List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).


*/

import java.util.*;
class Question3 {

	static ArrayList<LinkedList<TreeNode>> findLinkedListOfDepths(TreeNode root) {

		ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();

		LinkedList<TreeNode> current = new LinkedList<>();


		if (root != null) {
			current.add(root);
		}


		while (!current.isEmpty()) {
			result.add(current);

			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			for (TreeNode parent : parents) {
				if (parent.left != null) {
					current.add(parent.left);
				}
				if (parent.right != null) {
					current.add(parent.right);
				}
			}
		}

		return result;
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

		ArrayList<LinkedList<TreeNode>> result = findLinkedListOfDepths(node2);

		for (int i = 0 ; i < result.size() ; i++) {
			LinkedList<TreeNode> list = result.get(i);
			System.out.println("Level  " + i + " : " + list.toString());
		}
	}


}