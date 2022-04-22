/*

Problem : Rotate Matrix : Given an image represented by NxN matrix , write the method to rotate the image by 90 degrees.
If possible do this in place.

*/


public class Question7{


	private static String[][] rotateMatrix(String[][] matrix){

		if(matrix.length < 0 || (matrix.length != matrix[0].length))return matrix;

		int n = matrix.length;


		for(int layer = 0 ; layer < N/2 ; layer++){

			int first = layer;
			int last = n - 1 - layer;


			for(int i = first ; i < last ; i ++){

				int offset = i -first ;

				int top = matrix[first][i]; // save top -> A

				matrix[first][i] = matrix[last-offset]



			}
		}




		return matrix;
	}


	public static void main(String[] args) {
		
		int n = 4;
		String[][] matrix = new String[n][n];


		for(int i = 0; i < n;i++){
			for(int j = 0; j < n ; j++){
				matrix[i][j] = String.valueOf(i) + String.valueOf(j);
			}
		}

		for(int i = 0; i < n;i++){
			for(int j = 0; j < n ; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("\nRotating matrix by 90 degree\n");
		rotateMatrix(matrix);

		for(int i = 0; i < n;i++){
			for(int j = 0; j < n ; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}



	}
}


