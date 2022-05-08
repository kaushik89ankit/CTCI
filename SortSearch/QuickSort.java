/*
Like Merge Sort, QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and
partitions the given array around the picked pivot. There are many different versions of
quickSort that pick pivot in different ways. 

Always pick first element as pivot.
Always pick last element as pivot (implemented below)
Pick a random element as pivot.
Pick median as pivot.
The key process in quickSort is partition(). Target of partitions is, given an array and an 
element x of array as pivot, put x at its correct position in sorted array and put all smaller 
elements (smaller than x) before x, and 
put all greater elements (greater than x) after x. All this should be done in linear time.

Complexity Analysis

Time Complexity of Quick sort

Best case scenario: The best case scenario occurs when the partitions are as evenly balanced 
as possible, i.e their sizes on either side of the pivot element are either are equal or are 
have size difference of 1 of each other.

Case 1: The case when sizes of sublist on either side of pivot becomes equal occurs when the 
subarray has an odd number of elements and the pivot is right in the middle after partitioning.
Each partition will have (n-1)/2 elements.
Case 2: The size difference of 1 between the two sublists on either side of pivot happens if 
the subarray has an even number, n, of elements. One partition will have n/2 elements with the 
other having (n/2)-1.
In either of these cases, each partition will have at most n/2 elements, and the tree 
representation of the subproblem sizes will be as below:

Best Case

The best-case complexity of the quick sort algorithm is O(n logn)

Worst case scenario: This happens when we encounter the most unbalanced partitions possible, 
then the original call takes n time, the recursive call on n-1 elements will take (n-1) time, 
the recursive call on (n-2) elements will take (n-2) time, and so on. The worst case time 
complexity of Quick Sort would be O(n2).

Quick Sort - Worst Case

Space Complexity of Quick sort
The space complexity is calculated based on the space used in the recursion stack. 
The worst case space used will be O(n) . The average case space used will be of the order 
O(log n). The worst case space complexity becomes O(n), when the algorithm encounters its 
worst case where for getting a sorted list, we need to make n recursive calls.

*/

public class QuickSort{

	static void  printArray(int[] array){
		for(int obj : array){
			System.out.print(obj + " ");
		}
		System.out.println();
	}


	static void quickSort(int[] source , int low , int high){
			if(low < high){
			int partition = partition(source,low,high);
			quickSort(source,low,partition-1);
			quickSort(source,partition+1,high);
		}
	}

	static int partition(int[] source , int low , int high){

		int pivot = (low + high)/2;

		int i = low;
		int j = high;

		while(i < j){

			while(source[i] < source[pivot]){
				i++;
			}

			while(source[j] > source[pivot]){
				j--;
			}
			if(i < j){
				swap(source,i,j);
				i++;
				j--;
			}
		}

		return i;

	}

	static void swap(int[] source, int i , int j){
		int temp = source[i];
		source[i] = source[j];
		source[j] = temp;
	}

	public static void main(String[] args) {
		int[] input = {3,9,45,23,1};
		System.out.println("Before Sorting :");
		printArray(input);
		System.out.println("After Quick Sorting : ");
		quickSort(input,0,input.length-1);
		printArray(input);
	}
}