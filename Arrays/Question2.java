
/*

Need to check if one string is the permutation of another given string.

Assumption :

1. Comparison is case sensitive and whitespace senstive too. "God" is different from "       god".
2. Characters are from ASCII


*/

public class Question2{

	private static String permutation1 = "kaku";

	private static String permutation2 = "akuk";

	private static String nonpermutation1 = "ankit";

	private static String nonpermutation2 = "akkit";


static boolean isPermutation(String s , String t){

	if(s.length() != t.length()){
		return false;
	}

	int[] charArray = new int[128];

	for(int i =0; i < s.length();i++){
		charArray[s.charAt(i)]++;
	}


	for(int i=0; i < t.length();i++){
		charArray[t.charAt(i)]--;
		if(charArray[t.charAt(i)] < 0){
			return false;
		}
	}

	return true;

}


	public static void main(String[] args){


		System.out.println("This should return true : " + isPermutation(permutation2,permutation1));


		System.out.println("This should return false :" + isPermutation(nonpermutation2,nonpermutation1));
	}
}



// Time complexity = O(n)
// Space Complexity = O(c) where c is the size of alphabet set