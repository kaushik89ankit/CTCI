/*

Problem : The Longest Increasing Subsequence (LIS) problem is to find the length of the longest 
subsequence of a given sequence such that all elements of the subsequence are sorted in 
increasing order. 


Input: arr[] = {3, 10, 2, 1, 20}
Output: Length of LIS = 3
The longest increasing subsequence is 3, 10, 20

Input: arr[] = {3, 2}
Output: Length of LIS = 1
The longest increasing subsequences are {3} and {2}

Input: arr[] = {50, 3, 10, 7, 40, 80}
Output: Length of LIS = 4
The longest increasing subsequence is {3, 7, 40, 80}

*/



public class LongestIncreasingSubsequence{


	static int findLISRecursively(int[] input){

		return findLISRecursively(input,input.length -1);
	}

	static int findLISRecursively(int[] input, int index){

		if(index == 0){
			return 1;
		}

		int max = 0;

		for(int i = index-1 ; i >=0 ;i--){
			if(input[i] < input[index]){
				int localMax = findLISRecursively(input,i);
				if(localMax > max){
					max = localMax;
				}
			}
		}

		return max + 1;
	}



	public static void main(String[] args) {
		
		int[] input = {50, 3, 10, 7, 40, 80};

		int result = findLISRecursively(input);		

		System.out.println("Result : " + result);

	}

}







