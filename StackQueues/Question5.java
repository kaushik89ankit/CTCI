/*

Problem : Program to sort a stack such that the smallest numbers are  on the top

*/

public class Question5 {


	static void sortStackAsCTCI(Stack s) {

		Stack<Integer> r = new Stack<Integer>();
		int loop =1;
		while(!s.isEmpty()){
			
			System.out.println(loop++);
			
			int tmp = (Integer)s.pop();

			while( !r.isEmpty() && tmp < (Integer)r.peek()){
				s.push(r.pop());
			}

			r.push(tmp);
		}

		while(!r.isEmpty()){
			s.push(r.pop());
		}

	}

		static void sortStack(Stack unsorted) {

		Stack<Integer> sorted = new Stack<Integer>();
		int loop =1;
		while(!unsorted.isEmpty()){
			
			System.out.println(loop++);
			
			int tmp = (Integer)unsorted.pop();

			while( !sorted.isEmpty() && tmp < (Integer)sorted.peek()){
				unsorted.push(sorted.pop());
			}

			sorted.push(tmp);
		}

		

		while(!sorted.isEmpty()){
			unsorted.push(sorted.pop());
		}

	}


	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(30);
		stack.push(40);
		// stack.push(50);
		// stack.push(1);
		// stack.push(60);
		// stack.push(70);
		// stack.push(15);

		sortStack(stack);

		System.out.println("The min number in stack is : " + stack.peek() + " with size " + stack.size());
	}
}