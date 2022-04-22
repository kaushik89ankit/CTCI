/*
URLify
Problem : Need to replace every space char with "%20" considering the input is character array and true length is known. Also 
it needs to be done in place.



*/

import java.util.*;


public class Question3{


static char[] URLify(char[] input, int trueLength){

	int spaceCount = 0 , index = 0;

	for(int i = 0 ; i < trueLength ; i++){
		if(input[i] == ' '){
			spaceCount++;
		}
	}


	int finalLength = trueLength + spaceCount*2;

	index = finalLength -1 ;

	if(trueLength > input.length){
		return null;
	}

	input[index] = '\0'; // Is not needed 

	for(int i = trueLength-1;i>=0;i--){

		char c = input[i];

		if(c == ' '){
			input[index] = '0';
			input[index-1] = '2';
			input[index-2] = '%';
			index = index - 3;
		}else{
		input[index] = c;
		index--;
	}
	}

	return input;
}


public static void main(String[] args){

//	char[] input = ['M','R',' ','A','N','K','I','T',' ','K','A','U','S','H','I','K'];

	String inputString = "MR ANKIT KAUSHIK";

	char[] inputCharArray = new char[3*inputString.length()];

	for(int i = 0 ; i < inputString.length() ; i++){
		inputCharArray[i] = inputString.charAt(i);
	}

	System.out.println("The length of input char Array is " + inputCharArray.length);
	
	for(char c : inputCharArray){
		System.out.print(c);
	}	

	char[] result = URLify(inputCharArray,16);

	System.out.println("\nresult : \n");

	for(char c : result){
		System.out.print(c);
	}
}



}



// Time complexity = O(n)
// Space Complexity = O(1)