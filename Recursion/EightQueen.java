/*

Eight Queens: Write an algorithm to print all ways of arranging eight queens on an 8x8 
chess board so that none of them share the same row, column, or diagonal. 
In this case, "diagonal" means all diagonals, not just the two that bisect the board.

4x4

Let at ith value be the Queen placed at ith Row
result : {{0,2,3,1},{2,3,0,1}}
*/

import java.util.*;
public class EightQueen{

	static int GRID_SIZE = 8;

	private static void drawLine() {
        StringBuilder line = new StringBuilder();
        for (int i=0;i<GRID_SIZE*2+1;i++)
            line.append('-');
        System.out.println(line.toString());
    }

	static void printBoard(Integer[] rows){

		for(int i = 0 ; i < GRID_SIZE ; i++){
			for(int j = 0 ; j < GRID_SIZE ; j++){
				if(rows[i]==j){
					System.out.print(" Q|");
				}else{
					System.out.print(" |");
				}
			}
			System.out.println();
			drawLine();
		}
	}

	static List<List<Integer>> solveNQueen(int n){

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> comb = new ArrayList<Integer>(GRID_SIZE);

		for(int i = 0 ; i < GRID_SIZE;i++){
			comb.add(0);
		}

		solveNqueenUtil(0,result,comb);
		return result;
	}

	static void solveNqueenUtil(int row , List<List<Integer>> result , List<Integer> comb ){

		if(row == GRID_SIZE){
			result.add(new ArrayList<>(comb));
			//System.out.println("Result added");
			return;
		}

		for(int col = 0 ; col < GRID_SIZE; col++){
			//System.out.println("Row: " + row + " , Column: " + col);
			if(isValid(comb,row,col)){
				comb.set(row,col);
			//	System.out.println(comb);
				solveNqueenUtil(row+1,result,comb);
			}
		}
	}

	static boolean isValid(List<Integer> comb , int row , int col){
		//System.out.println("Checking if valid for row : " + row + " ,column :" + col);
		//System.out.println(comb);
		for(int i = 0 ; i < row ; i++){

			int currentRow = i;
			int currentColumn = comb.get(i);
			
			//System.out.println(" currentRow : " + currentRow + " currentColumn : " + currentColumn);
			//System.out.println(comb);
			// same column
			if(currentColumn == col){
				return false;
			}

			//same diagonal
			int rowDifference = row - currentRow;
			int colDifference = Math.abs(currentColumn - col);
		//	System.out.println(" currentRow : " + currentRow + " currentColumn : " + currentColumn);
		//	System.out.println(" rowDifference: " + rowDifference + " , colDifference " + colDifference + "\n");
			if(rowDifference == colDifference)return false;
			
			//System.out.println(comb);
		}
//		System.out.println("Valid for row : " + row + " ,column :" + col);
		return true;
	}

	public static void main(String[] args) {
		
		List<List<Integer>> result = solveNQueen(GRID_SIZE);
		//System.out.println("Finished");
		for(List<Integer> comb : result){
			System.out.println(comb);
			//printBoard(result.toArray(new Integer[comb.size()]));
		}
		System.out.println("Result size : " + result.size());
	}
}