/*
Problem : Check to see if the given strings are a pair of palindromes. This means one string is a permutation of all non-letter characters 
of another string.

*/

import java.lang.*;

public class Question4{


private static int getNumericVal(char c){

	int numVal = Character.getNumericValue(c);

	if(numVal >= Character.getNumericValue('a') && numVal <= Character.getNumericValue('z') ){
		return numVal - Character.getNumericValue('a');
	}

	if(numVal >= Character.getNumericValue('A') && numVal <= Character.getNumericValue('Z')){
		return numVal - Character.getNumericValue('A');
	}

	return -1;
}

private static void populateCharFrequencyTable(int[] charFrequencyArray , String input){

	for(int i = 0 ; i < input.length() ; i++){

		int numericVal = getNumericVal(input.charAt(i));

		if(numericVal == -1){
			continue;
		}
		charFrequencyArray[numericVal]++;
	}
}


private boolean  isPalindrome(String input){

	int[] frequencyTable = new int[26];

	populateCharFrequencyTable(frequencyTable,input);

	boolean foundOdd = false;


	for(int i : frequencyTable){
		if(i%2 == 1){
			if(foundOdd){
				return false;
			}
			foundOdd = true;
		}
	}

	return true;
}


private boolean isPalindromeBitCheck(String input){

	int bitVector = 0;


	for(int i=0 ; i < input.length() ; i++){
		bitVector = toggleBit(bitVector , getNumericVal(input.charAt(i)));
	}


	if(((bitVector & (bitVector -1)) ==0) | (bitVector == 0)){
		return true;
	}

	return false;

}


private static int toggleBit(int bitVector , int index){
  
  if(index < 0){
  	return bitVector;

  }

  int mask = 1 << index;
 
  if((bitVector & mask) == 0 ){
  	return bitVector |= mask;
  }
  return 	bitVector &= ~mask ;


}




public static void main(String[] args) {
	
	 String input = "Tact Cao";

	Question4 Obj = new Question4();

	System.out.println("Input : " +  input);

	System.out.println("Is this string a permutaion of palindrome ? " + Obj.isPalindrome(input));

	System.out.println("Is this String a permutation of palindorme via bit factor check ?" + Obj.isPalindromeBitCheck(input));
}


}




// Time Complexity = O(n)

// Space Complexity = O(n) - via Array , O(1) via bitCheck