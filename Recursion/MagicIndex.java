/*

Magic Index: A magic index in an array A [ 0 ••• n -1] is defined to be an 
index such that A[ i] =i. Given a sorted array of distinct integers,
write a method to find a magic index, if one exists, in array A.

FOLLOW UP
What if the values are not distinct?

*/


public class MagicIndex{


	static int findMagicIndex(int[] array,int start , int end){

		if(start > end || array == null || array.length < 0)return -1;

		int mid  = (start + end)/2;

		if(array[mid] == mid){
			return mid;
		}else if(array[mid] < mid){
			return findMagicIndex(array,mid+1,end);
		}else{
			return findMagicIndex(array,start,mid-1);
		}
	}


	public static void main(String[] args) {
		
		int[] array = {-5,-3,2,3,6,7};

		System.out.print("Magic Index recusrively is : " + findMagicIndex(array,0,array.length-1));

	}

}


/*

There are no overlapping sub problems thus not the case for DP

Time Complexity - O(lgN)

Space Comlexity - O(lgN)



*/