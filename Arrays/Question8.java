/*

Problem : Write an algorithm such that if an element in MxN matrix is 0  then its entire row and column are set to 0
 Zero Matrix


*/

import java.util.*;

public class Question8{
	
	private static void zeroMatrix(int[][] matrix , int rows , int columns){

		boolean[] rowArray = new boolean[rows];

		boolean[] columnArray = new boolean[columns];

		for(int i = 0 ; i < rows ; i++){
			for(int j = 0 ; j < columns ; j++){
				if(matrix[i][j] == 0){
					rowArray[i] = true;
					columnArray[j] = true;
				}
			}
		}

		nullifyRows(matrix,rowArray);
		nullifyColumns(matrix,columnArray);

	}


	private static void nullifyRows(int[][] matrix , boolean[] rowsArray){

		for(int i = 0 ; i < rowsArray.length; i++){
			if(rowsArray[i]){
				nullifyIndividualRow(matrix,i);
			}		}
	}

	private static void nullifyColumns(int[][] matrix , boolean[] ColumnArray){

		for(int i = 0 ; i < ColumnArray.length; i++){
			if(ColumnArray[i]){
				nullifyIndividualColumn(matrix,i);
			}		}
	}

	private static void nullifyIndividualRow(int[][] matrix , int row){

		for(int i = 0 ; i < matrix[0].length ; i++){
			matrix[row][i] = 0;
		}

	}


	private static void nullifyIndividualColumn(int[][] matrix , int column){
		for(int i = 0 ; i < matrix.length ; i++){
			matrix[i][column] = 0;
		}
	}



	public static void main(String[] args) {
		
		int m = 4;
		int n = 5;
		int[][] matrix =  {{1,2,3,4,5},{6,7,0,9,10},{11,12,13,14,15},{16,17,18,19,0}};
		
		for(int[] row : matrix){
			System.out.println(Arrays.toString(row));			
		}

		zeroMatrix(matrix , m , n);
		System.out.println("\nAfter zero matrix operation : \n ");
		for(int[] row : matrix){
			System.out.println(Arrays.toString(row));			
		}


	}
}


// Time Complexity : O(MN)

//Space Complexity : max(O(M),O(N))