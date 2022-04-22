/*

Coins: Given an infinite number of quarters (25 cents), dimes (10 cents),
nickels (5 cents), and pennies (1 cent), write code to calculate the number 
of ways of representing n cents.

*/

import java.util.*;
public class Coins {

	static int numberOfWays(int[] denoms , int sum, int currentCoin){
		//System.out.println("Sum : " + sum + " , " + " currentCoin : " + currentCoin);
		if(sum < 0){
			return 0;
		}
		if(sum == 0){
			return 1;
		}
		int ways = 0;
		for(int coin = currentCoin ; coin < denoms.length ; coin++){
			ways = ways + numberOfWays(denoms,sum - denoms[coin],coin);
		} 
		return ways;
	}

	static int count(int S[], int m, int n)
{
     
    // If n is 0 then there is 1 solution
    // (do not include any coin)
    if (n == 0)
        return 1;
     
    // If n is less than 0 then no
    // solution exists
    if (n < 0)
        return 0;
 
    // If there are no coins and n
    // is greater than 0, then no
    // solution exist
    if (m < 0 && n >= 1)
        return 0;
 
    // count is sum of solutions (i)
    // including S[m-1] (ii) excluding S[m-1]
    return count(S, m - 1, n) +
           count(S, m, n - S[m]);
}

	static int countDP(int[] denoms , int sum){
		Arrays.sort(denoms);
		int n = denoms.length;
		int[][] dp = new int[n + 1][sum+1];

		dp[0][0] = 1;
		
		for(int row = 1 ; row <= n ; row++){
			for(int col = 0 ; col <= sum;col++){
				if(col < denoms[row-1]){
					dp[row][col] = dp[row-1][col];
				}else{
					dp[row][col] = dp[row-1][col] + dp[row][col-denoms[row-1]];
				}
			}
		}
		return dp[denoms.length][sum];
	}

	public static void main(String[] args) {
		int[] denoms = {2,3,5,10};
		int sum = 15;
		int ways = numberOfWays(denoms,sum,0);
		System.out.println("Result : " + ways);

        int m = denoms.length-1;
     
        System.out.println("Result via recursion : " + count(denoms, m, sum));


        System.out.print("Result via DP "+countDP(denoms,sum));

	}
}