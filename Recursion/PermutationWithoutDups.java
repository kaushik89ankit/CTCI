/*

Permutations without Dups: Write a method to compute all permutations of a string of unique
characters.


*/

import java.util.*;
class PermutationWithoutDups{


	static ArrayList<String> findPermutations(String input){

		if(input == null){
			return null;
		}

		if(input.length() ==1){

			ArrayList<String> temp =  new ArrayList<String>();
			temp.add(input);
			return temp;
		}

		ArrayList<String> result = new ArrayList<>();
		
		for(int i = 0 ; i < input.length() ;i++){
			ArrayList<String> perm = findPermutations(remove(input,i));
			Iterator itr = perm.iterator();

			while(itr.hasNext()){
				result.add(Character.toString(input.charAt(i)) + itr.next());
			}
		}

		return result;
	}

	static String remove(String input , int index){
		return input.substring(0,index) + input.substring(index+1);
	}


	public static void main(String[] args) {
		

		String input = "abc";


		ArrayList<String> permutation = findPermutations(input);

		Iterator itr = permutation.iterator();

		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}

}