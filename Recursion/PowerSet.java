/*

Power Set: Write a method to return all subsets of a set


*/
import java.util.*;
public class PowerSet{


	static ArrayList<String> findSubset(ArrayList<String> set , int index){

		if(index < 0){
			return new ArrayList<>();
		}

		ArrayList<String> result = findSubset(set,index -1);

		ArrayList<String> resultSet = new ArrayList<String>(result);
				
		for(String subset : result){
			resultSet.add(subset + set.get(index));
			//System.out.println(subset[i]); 
		}

		resultSet.add(set.get(index));

		return resultSet;
		
	}


	public static void main(String[] args) {
		

		ArrayList<String> set = new ArrayList<String>();

		set.add("a");
		set.add("b");
		set.add("c");

		ArrayList<String> resultSet = findSubset(set,set.size()-1);

		System.out.println(resultSet);

	}
}


/*

Time Complexity - O(n*2^n )

Space Complexity - O(2^n)


*/