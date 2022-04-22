/*
Input: symbol[]    = {T, F, T}
       operator[]  = {^, &}
Output: 2
The given expression is "T ^ F & T", it evaluates true
in two ways "((T ^ F) & T)" and "(T ^ (F & T))"

Input: symbol[]    = {T, F, F}
       operator[]  = {^, |}
Output: 2
The given expression is "T ^ F | F", it evaluates true
in two ways "( (T ^ F) | F )" and "( T ^ (F | F) )". 

Input: symbol[]    = {T, T, F, T}
       operator[]  = {|, &, ^}
Output: 4
The given expression is "T | T & F ^ T", it evaluates true
in 4 ways ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) 
and (T|((T&F)^T)).
*/

public class BooleanEvaluationGFG{

	static int countParenth(char[] symbols , char[] operators , int length){

		int[][] T = new int[n][n];
		int[][] F = new int[n][n];


		for(int i = 0 ; i < n ; i++){
			T[i][i] = (symbols[i] == 'T' ? 1 : 0);
			F[i][i] = (symbols[i] == 'F' ? 1 : 0);
		}

		


	}

	public static void main(String[] args) {
		 char symbols[] = "TTFT".toCharArray();
         char operators[] = "|&^".toCharArray();
         int n = symbols.length;
 
        // There are 4 ways
        // ((T|T)&(F^T)), (T|(T&(F^T))),
        // (((T|T)&F)^T) and (T|((T&F)^T))
         System.out.println(
          countParenth(symbols, operators, n));
	}

}