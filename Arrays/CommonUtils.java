public class CommonUtils{

	private static String[][] createMxNmatrix(int m , int n){

		String[][] matrix = new String[m][n];


		for(int i = 0; i < m;i++){
			for(int j = 0; j < n ; j++){
				matrix[i][j] = String.valueOf(i) + String.valueOf(j);
			}
		}
		return matrix;
	}

	private static void printMatrix(String[][] matrix){

		int m = matrix.length;

		int n = matrix[0].length;

		for(int i = 0; i < m;i++){
			for(int j = 0; j < n ; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
	}
}

	
