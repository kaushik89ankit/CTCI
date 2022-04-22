/*

Permutations with Dups: Write a method to compute all permutations of a string whose 
characters are not necessarily unique. The list of permutations should not have duplicates.

*/

import java.util.*;
class PermutationWithDups{


	static void buildFrequencyMap(String input,Map<Character,Integer> map){

		for(char c : input.toCharArray()){
			int count = 1;
			if(map.get(c) != null){
				count = map.get(c) + 1;
			}
			map.put(c,count);
		}
	}

	static void addWithSuffix(ArrayList<String> result, ArrayList<String> perms, char c){

		Iterator itr = perms.iterator();

		while(itr.hasNext()){
			result.add(Character.toString(c) + itr.next());
		}
	}



	static ArrayList<String> findPerms(Map<Character,Integer> map,int remaining){
		ArrayList<String> result = new ArrayList<>();
		if(remaining == 0){
			result.add("");
		}
		for(char c : map.keySet()){
			int count = map.get(c);
			if(count > 0){
				map.put(c,--count);
				ArrayList<String> perms = findPerms(map,remaining-1);
				map.put(c,++count);
				addWithSuffix(result,perms,c);
			}
			
		}
		return result;
	}

	

	public static void main(String[] args) {
		String input = "bbbbb";
		Map<Character,Integer> frequencyMap = new HashMap<>();
		buildFrequencyMap(input,frequencyMap);
		ArrayList<String> perms = findPerms(frequencyMap,input.length());
		Iterator itr = perms.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}

}

/*

Time Complexity = O(n^2*n!)
Space Complexity = O(n*n)

*/