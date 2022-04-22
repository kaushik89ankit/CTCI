/*

Problem : Implement a binary serach tree

*/


public class BinarySearchTree {

	TreeNode root;


	BinarySearchTree() {
		root = null;
	}

	void add(int value) {
		root = insertRec(root, value);
	}


	TreeNode insertRec(TreeNode node , int value) {

		if (node == null) {
			return new TreeNode(value);
		}

		if (value <= node.data) {
			node.left = insertRec(node.left , value);
		} else {
			node.right = insertRec(node.right , value);
		}

		return node;
	}

	boolean containsNode(int value) {
		return containsRec(root, value);
	}

	boolean containsRec(TreeNode node , int value) {


		if (node == null) {
			return false;
		}

		if (node.data == value) {
			return true;
		}

		if (node.data > value) {
			return containsRec(node.left , value );
		}

		return containsRec(node.right , value);
	}


	void delete(int value) {
		root =  deleteRec(root, value);
	}


	TreeNode deleteRec(TreeNode node , int value) {

		if (node == null) {
			return node;
		}


		if (node.data == value) {
			// if it is leaf
			if (node.left == null && node.right == null) {
				return null;
			}

			//if  it has one child
			if (node.right == null) {
				return node.left;
			}

			if (node.left == null) {
				return node.right;
			}

			// if it has two child
			node.data = findSmallestNode(node.right);
			node.right = deleteRec(node.right , node.data);
			return node;
		}

		if (value < node.data) {
			node.left = deleteRec(node.left , value);
			return node;
		}

		if (value > node.data) {
			node.right = deleteRec(node.right , value);
			return node;
		}

		return node;
	}


	int findSmallestNode(TreeNode node) {
		while (node.left != null) {
			node = node.left;
		}

		return node.data;
	}



	public static void main(String[] args) {

		BinarySearchTree bt = new BinarySearchTree();

		bt.add(6);
		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);

		System.out.println("Should be true : " + bt.containsNode(9));

		bt.delete(8);
		System.out.println("Should be false : " + bt.containsNode(8));
	}




}
