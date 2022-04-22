/*

Problem : Write a code to check if Sting s1 is a rotation of String S2 using only one call to isSubstring()


String Rotation

*/
import java.lang.*;

public class Question9{


	private static boolean isStringRotated(String s1 , String s2){

		if((s1.length() == s2.length()) && s1.length() > 0){
	
		 s1 = s1 + s1 ;
		 return s1.contains(s2);
		}

		return false;
	}


	public static void main(String[] args) {
		
		String s1 = "waterbottle";

		String s2 = "erbottlewat";


		System.out.println("Are these two strings : " + s1 + " and " + s2 + " 'string rotated' ? " + isStringRotated(s1,s2));

	}



}