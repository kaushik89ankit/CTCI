/*
Implement an algorithm to determine if a string has all unique characters. 
What if you can not use additional data structures ?

*/

public class Question1 {

	private static String nonUnique = "aabchhsdjcnckndkvkvjkdbxjdkjfkj";

	private static String unique = "abcdefghij";

	static int charNum = 26;

	static boolean  findIfUnique(String input){

		if(input.length() > charNum){
			return false;
		}

		int[] charArray = new int[charNum];

		char[] inputArray = input.toCharArray();

		int val ;

		for(char c : inputArray){
			val = (int)c - 97;
			if(charArray[val] == 1){
				return false;
			}

			charArray[val] = 1;
		}

		return true;
	}



	public static void main(String[] args){

		boolean isUnique = findIfUnique(unique);

		boolean isNotUnique = findIfUnique(nonUnique);


		System.out.println("This value should be true : " + isUnique);

		System.out.println("This value should be false : " + isNotUnique);

	}
}


// Space Complexity - O(c)
// Time Complexity - O(c)
// Where c is the number of alphabets
