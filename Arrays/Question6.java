
/*

Problem : String compression : Perform basic string comression using the count of repeated characters. If compressed string is
 		  longer than original , return original string.

Assumptions : Only lowercase and uppercase letters are there

*/


public class Question6{



	private static String compressString(String input){

		StringBuilder builder = new StringBuilder();

		int count = 0;

		for (int i = 0 ; i < input.length() ; i++){
			count++;
			if((i+1 >= input.length())||(input.charAt(i+1) != input.charAt(i))){
				builder.append(input.charAt(i));
				builder.append(count);
				count = 0;
				continue;
			}
			//builder.append(input.charAt(i));
		}

		return input.length() > builder.toString().length() ? builder.toString() : input;
	}


	public static void main(String[] args) {
		
		String input = "abcdddddddd";


		System.out.println("The input is : " + input);

		System.out.println("The compressed form is : " + compressString(input));
	}
}


//Time Complexity = O(n)

//Space complexity = O(n)

