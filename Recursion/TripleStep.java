/*

Triple Step: A child is running up a staircase with n steps and can hop either 
1 step, 2 steps, or 3 steps at a time. Implement a method to count how many 
possible ways the child can run up the
stairs.

*/


class TripleStep{


	int numberOfWays(int steps,int[] hops, int[] memo){

		if(steps < 0){
			return 0;
		}

		if(steps == 0){
			return 1;
		}

		int numberOfWays = 0;

		for(int i : hops){
			if((steps - i) >= memo.length || (steps -i) < 0)continue;
			if(memo[steps-i] != -1){
			  numberOfWays = numberOfWays + numberOfWays(steps - i,hops,memo);	
			}else{
			  memo[steps-i] = numberOfWays(steps - i,hops,memo);
			  numberOfWays = numberOfWays + memo[steps-i];				
			}		
		}

		return numberOfWays;

	}


	public static void main(String[] args) {
		
		TripleStep tripleStep = new TripleStep();
		
		int steps = 3;

		int[] hops = {1,2,3};
		int[] mem = new int[3];

		for(int i = 0 ; i < mem.length ; i++){
			mem[i] = -1;
		}
		int numberOfWays = tripleStep.numberOfWays(steps,hops,mem);

		System.out.println("The number of ways recursively : " + numberOfWays);
	}
}

// steps size = m
// hops.length = n

// For recursive , time complexity = O(n^m)
// Space complexity = O(m)


// For memoized version , time complexity = O(n*m)
// Space complexity = O(m)

