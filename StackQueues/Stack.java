/*

Stack implementation using double capacity with array.

Main ops : push , pop , peek , isEmpty , size

*/

import java.util.*;

public class Stack<T> {

	static int INITIAL_SIZE = 8;
	int size = 0;
	ArrayList<T> array;


	public Stack(){
		array = new ArrayList<T>(INITIAL_SIZE);
	}

	public Stack(int size){
		array = new ArrayList<T>(size);
	}

	void push(T x){
		array.add(x);
		size++;
	}

	boolean isEmpty(){
		return size == 0;
	}

	int size(){
		return size;
	}

	T pop(){

		if(isEmpty()){
			return null;
		}
		size--;
		return array.get(size);
	}

	T peek(){
		if(isEmpty()){
			return null;
		}	

		return (T)array.get(size-1);
	}
	
	public String toString(){

		StringBuilder result = new StringBuilder();

		for(int i = 0 ; i < size ; i++){
			T x = array.get(i);
			result.append("\n" + x.toString());
		}

		return result.toString();
	}

	public static void main(String[] args) {
		
	}

}