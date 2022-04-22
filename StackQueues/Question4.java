/*

Problem : Implement a MyQueue Class which implements a queue using 2 stacks

*/


class MyQueue {

	Stack<Integer> newestStack;
	Stack<Integer> oldestStack;

	MyQueue(int capacity) {
		newestStack = new Stack<Integer>(capacity);
		oldestStack = new Stack<Integer>(capacity);
	}

	void enqueue(int value) {

		if (newestStack.isEmpty() && !oldestStack.isEmpty()) {
			shiftStack(newestStack, oldestStack);
		}

		newestStack.push(value);
	}

	int dequeue() {

		if (!oldestStack.isEmpty()) {
			return oldestStack.pop();
		}

		if (!newestStack.isEmpty()) {
			shiftStack(oldestStack, newestStack);
			return newestStack.pop();
		}

		return 0;

	}

	int peek() {

		if (!oldestStack.isEmpty()) {
			return oldestStack.peek();
		}


		if (!newestStack.isEmpty()) {
			shiftStack(oldestStack, newestStack);
			return oldestStack.peek();
		}

		return 0;

	}

	int size() {
		return Math.max(oldestStack.size(), newestStack.size());
	}

	void shiftStack(Stack s1 , Stack s2) {

		while (s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}

}


class Question4 {

	public static void main(String[] args) {

		MyQueue queue = new MyQueue(10);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.enqueue(60);
		queue.enqueue(70);
		queue.enqueue(80);
		queue.enqueue(90);

	    queue.dequeue();


		while(queue.size() != 0){
			System.out.println("Data : " + queue.dequeue() + " , Size : " + queue.size()6);
		}

	}

}