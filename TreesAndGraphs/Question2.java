
/*

Problem: Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm to
create a binary search tree with minimal height.


*/


class Question2 {

	static TreeNode createBSTMinimum(int[] input , int startIndex , int lastIndex) {

		if (startIndex > lastIndex) {
			return null;
		}

		int middleIndex = (startIndex + lastIndex) / 2;

		int data = input[middleIndex];

		TreeNode root = new TreeNode(data);

		root.left = createBSTMinimum(input , startIndex ,  middleIndex - 1);
		root.right = createBSTMinimum(input ,  middleIndex + 1 , lastIndex);


		return root;

	}


	public static void main(String[] args) {


		int[] input = {2, 4, 5, 6, 7, 11, 17, 23, 27};


		TreeNode root = createBSTMinimum(input , 0 , input.length - 1);

		System.out.print("The root of BST is " + root.data);
	}


}