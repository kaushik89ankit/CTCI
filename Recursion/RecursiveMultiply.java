/*

Recursive Multiply: Write a recursive function to multiply two positive integers
without using the * operator.You can use addition, subtraction, and bit shifting,
but you should minimize the number of those operations.

*/


public class RecursiveMultiply{

	static int recursiveMultiply(int m , int n){

		if(m < 0 || n < 0){
			return -1;
		}

		if(m == 0 || n == 0){
			return 0;
		}

//		int half = n >> 1;

		int halfProd = recursiveMultiply(m,n >> 1);

		if(n%2 ==0){
			return halfProd + halfProd;
		}else{
			return halfProd + halfProd + m;
		}

	}


	public static void main(String[] args) {
		
		int m = 2;
		int n = 1 ;

		int bigger = m > n ? m : n;
		int smaller = m > n ? n : m;

		int result = recursiveMultiply(bigger,smaller);

		System.out.println("Result : " + result);
	}
}


/*

s = smaller number

Time Complexity = O(lgS)

Space COmplexity = O(lgS)



*/