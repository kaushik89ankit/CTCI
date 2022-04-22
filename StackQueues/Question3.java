/*
Problem : Stack of Plates - Implement a data structure SetofStacks which can create another stack if previous is full
All othe rperations as if it is one stack
*/
import java.util.*;

class SetOfStack {

	ArrayList<Stack> listOfStack ;
	int stackCapacity ;


	SetOfStack(int stackCapacity) {
		listOfStack = new ArrayList<Stack>();
		this.stackCapacity = stackCapacity;
		listOfStack.add(new Stack(stackCapacity));
	}

	void push(int value) {
		Stack currentStack = this.getCurrentStack();
		if (currentStack != null && (currentStack.size != stackCapacity)){
			currentStack.push(value);
		}else{
			currentStack = new Stack<Integer>(stackCapacity);
			listOfStack.add(currentStack);
			currentStack.push(value);
		}

	}

	int pop() {
		Stack currentStack = this.getCurrentStack();
		if(currentStack == null || currentStack.isEmpty()){
			return 0;
		}
		int value = (int)currentStack.pop();
		if (currentStack.isEmpty()) {
			this.removeLastStack();
		}
		return value;
	}

	void removeLastStack(){
		int lastIndex = listOfStack.size() -1 ;

		listOfStack.remove(lastIndex);
	}



	int peek() {
		Stack currentStack = this.getCurrentStack();
		return (int)currentStack.peek();
	}

	boolean isEmpty() {
		Stack currentStack = this.getCurrentStack();
		return currentStack.isEmpty();
	}


	Stack getCurrentStack() {

		Stack currentStack = listOfStack.get(listOfStack.size() - 1);
		return currentStack;
	}


}



public class Question3 {



	public static void main(String[] args) {

		SetOfStack stack = new SetOfStack(2);

		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.push(70);
		stack.push(15);
//		stack.pop();

		System.out.println("The top value : " + stack.peek());
	}
}