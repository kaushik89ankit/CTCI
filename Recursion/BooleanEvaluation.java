/*

Problem : Boolean Evaluation: Given a boolean expression consisting of the 
symbols 0 (false), 1 (true), &(AND), | (OR), and ^ (XOR), and a desired boolean
result value result, implement a function to count the number of ways of 
parenthesizing the expression such that it evaluates to result.

EXAMPLE
countEval("1^0|0|1", false) -> 2
countEval("0&0&0&1^1|0", true) -> 10

*/


class BooleanEvaluation{


	static int countEval(String input , boolean result){

		if(input == null || input.length() == 0 ){
			return 0;
		}

		if(input.length() == 1){
			return (stringToBoolean(input) == result ? 1 : 0);
		}

		int ways = 0;

		for(int i = 1;i<input.length();i=i+2){
			String left = input.substring(0,i);
			String right = input.substring(i+1,input.length());

			char operand = input.charAt(i);
			int leftTrue = countEval(left,true);
			int leftFalse = countEval(left,false);
			int rightTrue = countEval(right,true);
			int rightFalse = countEval(right,false);

			int totalWays  = (leftTrue + leftFalse)*(rightTrue + rightFalse);

			if(operand == '&'){
				if(result){
					ways = ways + leftTrue*rightTrue;
				}else{
					ways = ways + (totalWays-leftTrue*rightTrue);
				}
			}else if(operand == '|'){
				if(result){
					ways = ways + (totalWays - leftFalse*rightFalse);
				}else{
					ways = ways + leftFalse*rightFalse;
				}
			}else if(operand == '^'){
				if(result){
					ways = ways + (leftTrue*rightFalse + leftFalse*rightTrue);
				}else{
					ways = ways + leftFalse*rightFalse + leftTrue*rightTrue;
				}
			}

		}

		return ways;

	}

	static boolean stringToBoolean(String input){

		if(input.equals("1")){
			return true;
		}

		return false;
	}


	public static void main(String[] args) {
		
		String input = "1^0|0|1";
		boolean result = false;

		int count = countEval(input,result);

		System.out.println("For input,result : {" + input + ","+ result +"}");
		System.out.println("Number of ways : " + count);
	}
}