/*

Problem : Given two strings , check if they are one edit ( insert , delete , replace) away 

*/


public class Question5{




	private static boolean isOneEditAway(String s1  , String s2){

		if(s1.length() == s2.length()){
			return isOneReplaceAway(s1,s2);
		}else if(s1.length() + 1 == s2.length()){
			return isOneInsertAway(s1,s2);
		}else if(s2.length() + 1 == s1.length()){
			return isOneInsertAway(s2,s1);
		}

		return false;
	}

	// 'bale' - 'bable' true
	private static boolean isOneInsertAway(String s1,String s2){

		int index1 = 0; 
		int index2 = 0;

		while((index2 < s2.length()) && (index1 < s1.length())){

			if(s1.charAt(index1) != s2.charAt(index2)){

				if(index1 != index2){
					return false;
				}
				index2++;
			}else{
				index1++;
				index2++;
			}
		}


		return true;
	}


	private static boolean isOneReplaceAway(String s1 ,  String s2){
		boolean foundDifferentChar = false;

		for(int i = 0 ; i< s1.length(); i++){
			if(s1.charAt(i) != s2.charAt(i)){
				if(foundDifferentChar){
					return false;
				}
				foundDifferentChar = true;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		

		String s1 = "pale";

		String s2 = "pae";


		System.out.println("The inputs : " + s1 +  " & " + s2 + " are one edit away ? " + isOneEditAway(s1,s2) );
	}
}



//  Time Complexity = O(n)

// Space Complexity = O(1)