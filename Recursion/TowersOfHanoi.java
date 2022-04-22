/*

Towers of Hanoi: In the classic problem of the Towers of Hanoi, you have 3 towers and N 
disks of different sizes which can slide onto any tower. The puzzle starts with disks 
sorted in ascending order of size from top to bottom (i.e., each disk sits on top of an 
even larger one). You have the following constraints:

(1) Only one disk can be moved at a time.
(2) A disk is slid off the top of one tower onto another tower.
(3) A disk cannot be placed on top of a smaller disk.

Write a program to move the disks from the first tower to the last using stacks.

*/

import java.util.*;
public class TowersOfHanoi{

	Stack<Integer> source;
	Stack<Integer> buffer;
	Stack<Integer> destination;

	public TowersOfHanoi(int n){
		source = new Stack<Integer>();
		buffer = new Stack<Integer>();
		destination = new Stack<Integer>();
		for(int i = n ; i > 0; i--){
			source.add(i);
		}
	}

	public void printStack(Stack<Integer> stack){
		Iterator iterator = stack.iterator();
		System.out.println("Printing contents of stack ");
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}

	public void bottomToTop(Stack<Integer> s)
    {
        if (s.isEmpty() == true)
        {
            return;
        }
        // Get top element
        int element = s.peek();
        // Remove top
        s.pop();
        System.out.println(" " + element);
        // Recursively calling process
        bottomToTop(s);
        // Display element
        
        //  Push back to stack
        s.push(element);
    }


    public void solve(Stack<Integer> source , Stack<Integer> destination , Stack<Integer> buffer, int size){

    	if(size == 1){
    		move(source,destination);
    		return;
    	}

    	solve(source,buffer,destination,size-1);
    	move(source,destination);
    	solve(buffer,destination,source,size-1);

    }


    void move(Stack<Integer> from,Stack<Integer> to){

    	int s = from.pop();
    	System.out.println("Moving item " + s + " from " + from + " to " + to);
    	to.add(s);
    }


	public static void main(String[] args) {
		
		TowersOfHanoi towers = new TowersOfHanoi(2);

		//towers.printStack(towers.source);
		towers.bottomToTop(towers.source);

		towers.solve(towers.source,towers.destination,towers.buffer,towers.source.size());
	}


}