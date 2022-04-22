/*

Parens: Implement an algorithm to print all valid (e.g., properly opened and closed) combinations
of n pairs of parentheses.
EXAMPLE
Input: 3
Output: ( ( () ) ) , ( () () ) , ( () ) () , () ( () ) , () () ()

*/

public class Parens{


	static void _printParenthesisCharacterArray(char[] str , int current , int n , int open , int closed){


		if(closed == n){
			for(char c : str){
				System.out.print(c);
			}
			System.out.println();
		}else{

			if(open < n){
				str[current] ='{';
				_printParenthesisCharacterArray(str,current+1,n,open+1,closed);
			}

			if(closed < open){
				str[current] = '}';
				_printParenthesisCharacterArray(str,current+1,n,open,closed+1);
			}

		}


	}


	static void printParenthesisCharacterArray(char[] str,int n){

		_printParenthesisCharacterArray(str,0,n,0,0);

	}


	static void printParenthesisEmptyString(int n){

		_printParenthesisEmptyString("",n,n,n);
	}


	static void _printParenthesisEmptyString(String str , int n , int openParens , int closeParens){

		if(openParens < 0 || closeParens < 0){
			return;
		}

		if(closeParens == 0){
			System.out.println(str);
		}

		if(openParens > 0){
			_printParenthesisEmptyString(str + "{",n,openParens-1,closeParens);
		}

		if(closeParens > openParens){
			_printParenthesisEmptyString(str + "}",n,openParens,closeParens-1);
		}
	}


	public static void main(String[] args) {
			
			int n = 3;
        	char[] str = new char[2 * n];
        	System.out.println("Method with character array");
        	printParenthesisCharacterArray(str, n);

        	System.out.println("Method with empty String");
        	printParenthesisEmptyString(n);
	}
}