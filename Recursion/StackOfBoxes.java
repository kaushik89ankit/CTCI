/*

Stack of Boxes: You are given a set of n types of rectangular 3-D boxes, where the i^th box
has height h(i), width w(i) and depth d(i) (all real numbers). You want to create a stack of
boxes which is as tall as possible, but you can only stack a box on top of another box if 
the dimensions of the 2-D base of the lower box are each strictly larger than those of the 
2-D base of the higher box. Of course, you can rotate a box so that any side functions as 
its base. It is also allowable to use multiple instances of the same type of box. .

*/
import java.util.*;
public class StackOfBoxes{

	static final int minDimension = 3;
	static final int maxDimension = 20;

	private Box[] getRandomBoxStack(int n){
		Box[] stack = new Box[n];
		for(int i = 0 ; i < n;i++){
			stack[i] = getRandomBox();
		}
		return stack;
	}

	 Box getRandomBox(){	
		return new Box(getRandomInt(),getRandomInt(),getRandomInt());
	}

	 int getRandomInt(){
		Random random = new Random();
		return random.nextInt(StackOfBoxes.maxDimension-StackOfBoxes.minDimension) + StackOfBoxes.minDimension;
	}

	static void print(Box[] boxStack){
	//	System.out.println("length | breadth | width");
		for(Box box : boxStack){
			System.out.print(box.toString() + ",");
		}
	}

	private Box[] getShuffledStack(Box[] boxStack){

		int size = boxStack.length*6;
		Box[] shuffledStack = new Box[size];

		for(int i = 0 ; i < boxStack.length;i++){
			Box box = boxStack[i];
			shuffledStack[6*i] = new Box(Math.max(box.length,box.breadth),Math.min(box.length,box.breadth),box.height);
			shuffledStack[6*i+1]=new Box(Math.max(box.height,box.breadth),Math.min(box.height,box.breadth),box.length);
			shuffledStack[6*i+2]=new Box(Math.max(box.length,box.height),Math.min(box.length,box.height),box.breadth);
			shuffledStack[6*i+3] = new Box(Math.min(box.length,box.breadth),Math.max(box.length,box.breadth),box.height);
			shuffledStack[6*i+4]=new Box(Math.min(box.height,box.breadth),Math.max(box.height,box.breadth),box.length);
			shuffledStack[6*i+5]=new Box(Math.min(box.length,box.height),Math.max(box.length,box.height),box.breadth);
			
		}

		return shuffledStack;	

	}

	private int getMaxStackHeight(Box[] shuffledStack){

		int height = 0;

		for(int i = 0 ; i < shuffledStack.length ; i++){
			int maxHeight = getMaxStackHeight(shuffledStack,i);
			height = Math.max(height,maxHeight);
		}

		return height;
	}

	private int getMaxStackHeight(Box[] shuffledStack, int index){

		Box currentBox = shuffledStack[index];

		if(index == 0){
			return currentBox.height;
		}

		int maxHeight = 0;
		
		Box tempBox = null;
		for(int i = index -1 ; i >= 0; i--){
			tempBox = shuffledStack[i];
			if((tempBox.length < currentBox.length) && (tempBox.breadth < currentBox.breadth)){
				int heightAtI = getMaxStackHeight(shuffledStack,i);
				maxHeight = Math.max(heightAtI,maxHeight);
			}		
		}

		return maxHeight + currentBox.height;
	}

	public static void main(String[] args) {
		
		StackOfBoxes stack = new StackOfBoxes();
		//Box[] boxStack = stack.getRandomBoxStack(2);

		Box[] boxStack = { new Box(2,2,4), new Box(9, 7, 3)};
		print(boxStack);
		Box[] shuffledStack = stack.getShuffledStack(boxStack);
		Arrays.sort(shuffledStack,new SortByHeight());
		System.out.println("After sorting : ");
		print(shuffledStack);


		int maxHeight = stack.getMaxStackHeight(shuffledStack);
		System.out.println("MaxHeight : " + maxHeight);


//		ArrayList<Box> shuffledStack = stack.getShuffledStack(boxStack);
		
							
	}







	static class Box{

		int length;
		int breadth;
		int height;

		Box(int length , int breadth , int height){
			this.height=height;
			this.length=length;
			this.breadth=breadth;
		}


		public String toString(){
			return "(" +this.length + "," + this.breadth + "," + this.height + ")";
		}


	}
}


class SortByHeight implements Comparator<StackOfBoxes.Box>{

	@Override
	public int compare(StackOfBoxes.Box b1 , StackOfBoxes.Box b2){
		return b2.height - b1.height;
	}
}