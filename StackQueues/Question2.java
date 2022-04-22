/*

Problem - StackMin : Design a stack which can provide min operation at O(1)  complexity along with push and pop.
It should give minimum value present in stock.

*/
class StackMin {

	Stack stack;
	Stack minVal;

	StackMin(int size) {
		stack = new Stack<Integer>(size);
		minVal = new Stack<Integer>(size);
	}

	void push(int value) {

		stack.push(value);

		if (minVal.isEmpty()) {
			minVal.push(value);
			return;
		}

		if (value <= (int)minVal.peek()) {
			minVal.push(value);
		}

		
	}

	int pop() {
		int value = (int)stack.pop();
		if (value <= (int)minVal.peek()) {
			minVal.pop();
		}
		return value;
	}

	int peek() {
		return (int)stack.peek();
	}

	boolean isEmpty() {
		return stack.isEmpty();
	}

	int min() {

		if (stack.isEmpty()) {
			return 0;
		}
		return (int)minVal.peek();
	}
}



public class Question2 {



	public static void main(String[] args) {

		StackMin stack = new StackMin(30);

		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.push(70);
		stack.push(15);
		stack.pop();

		System.out.println("The min value : " + stack.min());

	}

}