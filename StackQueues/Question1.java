/*

Problem : Three in One - Use single array to implement three stacks
Assumption : Stack size is fixed.
*/

class FixedMultiStack {

	int numberOfStacks = 3;

	int stackCapacity;

	int[] values ;

	int[] sizes ;

	FixedMultiStack(int stackCapacity) {
		this.stackCapacity = stackCapacity;
		values = new int[stackCapacity * numberOfStacks];
		sizes = new int[numberOfStacks];
	}


	void push(int stackNum , int value ) throws Exception {
		if (isFull(stackNum)) {
			throw new Exception();
		}
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
	}

	int pop(int stackNum) throws Exception {
		if (isEmpty(stackNum)) {
			throw new Exception();
		}
		int topIndex = indexOfTop(stackNum);
		int value = values[topIndex];
		values[topIndex] = 0;
		sizes[stackNum]--;
		return value;
	}

	int peek(int stackNum) throws Exception {
		if (isEmpty(stackNum)) {
			throw new Exception();
		}

		return values[indexOfTop(stackNum)];
	}

	boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}

	boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}

	int indexOfTop(int stackNum) {
		int offset = stackNum * this.stackCapacity;
		return sizes[stackNum] + offset - 1;
	}

}




public class Question1 {



	public static void main(String[] args) throws Exception {

		FixedMultiStack stack = new FixedMultiStack(2);
		try {
			stack.push(0, 1);
			stack.push(1, 2);
			stack.push(2, 3);

			stack.push(0, 11);
			stack.push(1, 12);
			stack.push(2, 13);
			int val = stack.pop(1);
			System.out.println(val);
			//stack.push(0,11);
		}catch(Exception e){
			System.out.println("Assceam");
		}


	}



}


// Time Complexity 

// push - O(1)
// pop - O(1)
//peek - O(1)
// isEmpty - O(1)