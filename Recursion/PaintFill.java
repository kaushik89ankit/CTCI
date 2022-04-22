/*

Paint Fill: Implement the "paint fill" function that one might see on many image
editing programs.That is, given a screen (represented by a two-dimensional array
of colors), a point, and a new color,fill in the surrounding area until the color
changes from the original color.
*/

import java.util.concurrent.ThreadLocalRandom;

public class PaintFill {
	
	static final Color[] colours = Color.values();

	static void initialize(Color[][] screen){
		int row = screen.length;
		int column = screen[0].length;
		for(int i = 0 ; i < row ; i++){
			for(int j = 0; j < column ; j++){
				int randomNum = ThreadLocalRandom.current().nextInt(0, 4);
				screen[i][j] = colours[randomNum];
			}
		}
	}


	static void printScreen(Color[][] screen){
		int row = screen.length;
		int column = screen[0].length;
		for(int i = 0 ; i < row ; i++){
			for(int j = 0; j < column ; j++){ 
				System.out.print(screen[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void paintFill(Color[][] screen , int row , int column , Color originalColor , Color newColor){
		if(row < 0 || row >= screen.length || column < 0 || column >= screen[0].length || originalColor == newColor){
			return;
		}
		if(screen[row][column] == originalColor){
			screen[row][column] = newColor;
			paintFill(screen,row-1,column,originalColor,newColor); // up
			paintFill(screen,row,column-1,originalColor,newColor); // left
			paintFill(screen,row,column+1,originalColor,newColor); // left
			paintFill(screen,row+1,column,originalColor,newColor); // left
	 	}
	}


	public static void main(String[] args) {
		
		Color[][] screen = new Color[5][5];

		initialize(screen);
		System.out.println("Before : " + "\n");
		printScreen(screen);
		paintFill(screen,1,1,Color.BLUE,Color.RED);
		System.out.println("After : " + "\n");
		printScreen(screen);
	}
}




enum Color{
	RED,WHITE,BLUE,GREEN;
}



