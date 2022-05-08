/*
Complexity of Mergesort

Division:
It takes O(1)O(1) time to divide the problem into two parts.
To divide the problem, the algorithm computes the middle of the 
list by taking the length of the list and dividing by two, which takes constant time.

Combining the subproblems:
This is the merge step of mergesort. This step takes O(n) time, as shown in 
the analysis of the merge algorithm.

Overall time complexity of Merge sort is O(nLogn).
It is more efficient as it is in worst case also the runtime is O(nlogn)
The space complexity of Merge sort is O(n). This means that this algorithm
takes a lot of space and may slower down operations for the last data sets.


Pros
Time-efficient with time complexity of O(n \log n)O(nlogn)
Can be used for external sorting
Highly parallelizable
Stable sort

Cons
Marginally slower than quicksort in practice
Not as space-efficient as other sorting algorithms, e.g. block sort


*/


import java.util.*;
public class MergeSort {

	static void  printArray(int[] array){
		for(int obj : array){
			System.out.print(obj + " ");
		}
		System.out.println();
	}

	static void mergeSort(int[] source , int[] tempArray , int startIndex , int endIndex){
		if(startIndex < endIndex){
			int middleIndex = (startIndex + endIndex)/2;
			mergeSort(source,tempArray,startIndex,middleIndex);
			mergeSort(source,tempArray,middleIndex+1,endIndex);
			merge(source,tempArray,startIndex,middleIndex,endIndex);
		}
	}



	static void merge(int[] source,int[] tempArray , int startIndex , int middleIndex, int endIndex){

		for(int i = startIndex ; i <= endIndex ;i++){
			tempArray[i] = source[i];
		}

		int leftIndex = startIndex;
		int rightIndex = middleIndex+1;
		int sourceIndex = startIndex;


		while((leftIndex <= middleIndex)  && (rightIndex <= endIndex)){
			if(tempArray[leftIndex] <= tempArray[rightIndex]){
				source[sourceIndex] = tempArray[leftIndex];
				leftIndex++;
				sourceIndex++;
			}else{
				source[sourceIndex] = tempArray[rightIndex];
				rightIndex++;
				sourceIndex++;
			}
	 	}

	 	while(leftIndex <= middleIndex){
	 		//copyArray(source,tempArray,leftIndex,middleIndex);
	 		source[sourceIndex] = tempArray[leftIndex];
	 		sourceIndex++;
	 		leftIndex++;
	 	}
	 	while(rightIndex <= endIndex){
	 		//copyArray(source,tempArray,leftIndex,middleIndex);
	 		source[sourceIndex] = tempArray[rightIndex];
	 		sourceIndex++;
	 		rightIndex++;
	 	}


	}

	static void nWayMerge(int[] input , int[] tempArray,int startIndex , int endIndex){
		
	}



	public static void main(String[] args) {
		int[] input = {3,9,45,23,1};
		int[] tempArray = new int[input.length];
		System.out.println("Before Sorting :");
		printArray(input);
		System.out.println("After merge Sorting : ");
	//	mergeSort(input,tempArray,0,input.length-1);
		nWayMerge(input,tempArray,0,input.length-1);
		printArray(input);
	}

	
}