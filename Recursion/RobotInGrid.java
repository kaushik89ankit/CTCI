/*
Robot in a Grid: Imagine a robot sitting on the upper 
left corner of grid with r rows and c columns.
The robot can only move in two directions, right and down, but 
certain cells are "off limits" such that
the robot cannot step on them. Design an algorithm to 
              find a path for the robot from the top left to
the bottom right.

*/

public class RobotInGrid{


	static String findPath(int[][] grid , int row , int column){

		if(row == 0 && column ==0){
			return "0:0";
		}

		if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == -1){
			return null;
		}

		String path1  = findPath(grid,row-1,column);
		if(path1 != null){
			return path1 + "," + row +":" + column;
		}

		String path2  = findPath(grid,row,column-1);
		if(path2 != null){
			return path2 + "," + row + ":" + column;
		}

		return null;

	}

	static String findPathMemoized(int[][] grid , int row , int column , String[][] memo){

		if(row == 0 && column ==0){
			return "(0,0)";
		}

		if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == -1){
			return null;
		}

		String path1 = null;
		if(row > 0 && memo[row-1][column] != null){
			path1 = memo[row-1][column];
		}else{
			path1  = findPathMemoized(grid,row-1,column,memo);
			if(path1 != null)memo[row-1][column] = path1;
		}
		
		if(path1 != null){
			return path1 + " -> " + "(" +row + ","  + column + ")";
		}

		String path2 = null;
		if(column > 0 && memo[row][column-1] != null){
			path2 = memo[row][column-1];
		}else{
			path2  = findPathMemoized(grid,row,column-1,memo);
			if(path2 != null)memo[row][column-1] = path2;
		}
		
		if(path2 != null){
			return path2 + " -> " + "(" +row + ","  + column + ")";
		}

		return null;


	}


	public static void main(String[] args) {
		
		int[][] grid = new int[3][3];
		grid[1][1] = -1;
		grid[0][2] = -1;

		String output = findPath(grid,2,2);
	    System.out.println("The path via recursive " + output);
		String output2 = findPathMemoized(grid,2,2,new String[3][3]);
		System.out.println("The path is memoization " + output2);

	}

/*

grid = mxn


For recursive :

Time Complexity = O(2^(m+n))
Space Comlexity = O(m+n)


For memoized :

Time Complexity = O(m + n)
Space Complexity = O(m+n      )






*/

}