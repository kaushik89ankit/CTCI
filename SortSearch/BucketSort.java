/*

Bucket sort is a sorting technique that uses the Scatter-Gather-Approach to sort the array. 
It divides the unsorted array into separate groups and calls them buckets. Sort the individual 
buckets, and then gather them all together to form the final sorted array.


If the elements of the array are floats ranging between 0 and 1, we primarily make 10 buckets,
numbered from 0 to 9, and then insert elements into these buckets depending upon their most
significant number. The bucket index is calculated as: (int) (elementNumber * 10)
If the elements of the array are integers, as shown in the figure below, we simply calculate 
the range: range = (maximumNumber - minimumNumber) / noOfBuckets and divide the whole range 
into buckets and then perform bucket sorting.


Bucket Sort time complexity
Best Case Time Complexity: O(n+k)
Average Case Time Complexity: O(n)
Worst Case Time Complexity: O(n^2^)

Best Case Time Complexity:
If the array elements are uniformly distributed, bucket size will almost be the same for all 
the buckets. Hence, this will be the best case which will take up the least amount of time.
Sorting time complexity will reduce even further if all the elements inside each bucket are
already sorted. To create n buckets and scatter each element from the array, time complexity
= O(n). If we use Insertion sort to sort each bucket, time complexity = O(k). Hence, best
case time complexity for bucket sort = O(n+k), where n = number of elements, and k = number
 of buckets

Worst Case Time Complexity:
If the array elements are not uniformly distributed, i.e., elements are concentrated 
within specific ranges. This will result in one or more buckets having more elements 
than other buckets, making bucket sort like any other sorting technique, where every
 element is compared to the other. Time complexity increases even further if the elements 
 in the array are present in the reverse order. If insertion sort is used, the worst-case 
 time complexity can go up to O(n^2^).

Bucket Sort Space Complexity

Space Complexity : O(n+k)
Space Complexity for bucket sort is O(n+k), where n = number of elements in the array, 
and k = number of buckets formed Space taken by each bucket is O(k), and inside each bucket,
we have n elements scattered. Hence, the space complexity becomes O(n+k).

*/

import java.util.*;
public class BucketSort{

	static void  printArray(int[] array){
		for(int obj : array){
			System.out.print(obj + " ");
		}
		System.out.println();
	}


	static int findMax(int[] input){
		int max = Integer.MIN_VALUE;

		for(int i : input){
			if(i > max){
				max = i;
			}
		}
		return max;
	}

	static int findMin(int[] input){
		int min = Integer.MAX_VALUE;

		for(int i : input){
			if(i < min){
				min = i;
			}
		}

		return min;
	}

	static int hash(int i , int noOfBuckets){
		return i/noOfBuckets;
	}

	static void bucketSort(int[] input , int noOfBuckets){

		int max = findMax(input);
		int min = findMin(input);
		int range = (max - min)/noOfBuckets;
		System.out.println("Range : " + range);
		Object[] array = new Object[noOfBuckets];

		for(int i = 0 ; i < array.length; i++){
			array[i] = new ArrayList<Integer>();
		}

		ArrayList<Integer> ref =  null;
		for(int i : input){
			int index = hash(i,noOfBuckets);
			System.out.println("Index : " + index);
			ref = (ArrayList<Integer>)array[index];
			ref.add(i);
		}

		ArrayList<Integer> result = new ArrayList<>();

		for(Object obj : array){
			Collections.sort((ArrayList<Integer>)obj);
			result.addAll((ArrayList<Integer>)obj);
		}
		int index = 0;
		for(int i : result){
			input[index] = i;
			index++;
		}

	}

	public static void main(String[] args) {
		int[] input = {11, 9, 21, 8, 17, 19, 13, 1, 24, 12};
		System.out.println("Before Sorting :");
		printArray(input);
		int noOfBuckets = 5;
		bucketSort(input, noOfBuckets);
		System.out.println("After Quick Sorting : ");
		printArray(input);
	}
}