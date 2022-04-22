/*

Eight Queens: Write an algorithm to print all ways of arranging eight queens on an 8x8 
chess board so that none of them share the same row, column, or diagonal. 
In this case, "diagonal" means all diagonals, not just the two that bisect the board.

4x4

Let at ith value be the Quuen placed at ith Row
result : {{0,2,3,1},{2,3,0,1}}
*/

import java.util.*;
public class EightQueens{

	public static int GRID_SIZE = 4;


	public static void clear(Integer[] columns) {
		for (int i = 0; i < GRID_SIZE; i++) {
			columns[i] = -1;
		}
	}
	
	public static void printBoard(Integer[] columns) {
        drawLine();
        for(int i = 0; i < GRID_SIZE; i++){
			System.out.print("|");
			for (int j = 0; j < GRID_SIZE; j++){
			    if (columns[i] == j) {
			    	System.out.print("Q|");
			    } else {
			    	System.out.print(" |");
			    }
			}
            System.out.print("\n");
            drawLine();
		}
		System.out.println("");
	}

    private static void drawLine() {
        StringBuilder line = new StringBuilder();
        for (int i=0;i<GRID_SIZE*2+1;i++)
            line.append('-');
        System.out.println(line.toString());
    }


	
	public static void printBoards(ArrayList<Integer[]> boards) {
		for (int i = 0; i < boards.size(); i++) {
			Integer[] board = boards.get(i);
			printBoard(board);
		}
	}

	static boolean checkValid(Integer[] columns,int row , int newColumn){
		for(int i = 0 ; i < row;i++){
			int leftColumn = columns[i];
			// check if not in same column
			if(leftColumn == newColumn)return false;

			//check if not on the same diagonal
			int rowDistance = row - i;
			int columnDistance = Math.abs(leftColumn - newColumn);

			if(rowDistance == columnDistance){
				return false;
			}
		}
		return true;
	}

	public static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
		
		//Base case
		if (row == GRID_SIZE) { // Found valid placement
			results.add(columns.clone());
			return; 
		} 

		for (int col = 0; col < GRID_SIZE; col++) {			
			if (checkValid(columns, row, col)) {
				columns[row] = col;	// Place queen
				placeQueens(row + 1, columns, results);	
			}		
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		Integer[] columns = new Integer[GRID_SIZE];
		clear(columns);
		placeQueens(0, columns, results);
		printBoards(results);
		System.out.println(results.size());
	}
}