/*

Class for MinHeap Data Structure

*/

import java.util.*;

public class MinHeap {

	int[] heap;
	int capacity;
	int size ;

	public MinHeap(int capacity) {
		this.capacity = capacity;
		heap = new int[capacity];
		this.size = 0;
	}

	void ensureExtraCapacity() {
		if (size == capacity) {
			heap = Arrays.copyOf(heap, capacity * 2);
		}

		capacity *= 2;
	}

	void swap(int index1 , int index2) {
		int temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}


	int getParentIndex(int index) {

		return (index - 1) / 2;
	}

	int getLeftChildIndex(int index) {
		return (2 * index) + 1;
	}

	int getRightChildIndex(int index) {
		return 2 * (index + 1 );
	}

	boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}

	boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}

	int peek() {
		if (size == 0) {
			throw new IllegalStateException();
		}
		return heap[0];
	}


	void add(int value) {

		ensureExtraCapacity();
		heap[size] = value;
		size++;
		heapifyUp();
	}

	void heapifyUp() {

		int index = size - 1;

		while (hasParent(index) && (heap[index] < heap[getParentIndex(index)])) {
			swap(index, getParentIndex(index));
			index = getParentIndex(index);
		}

	}

	int poll() {
		if (size == 0) {
			throw new IllegalStateException();
		}
		int result = peek();
		heap[0] = heap[size - 1];
		size--;
		heapifyDown();
		return result;
	}


	void heapifyDown() {

		int index = 0;

		while (hasLeftChild(index)) {

			int smallerChildIndex = getLeftChildIndex(index);

			if (hasRightChild(index) && (heap[getRightChildIndex(index)] < heap[smallerChildIndex])) {
				smallerChildIndex = getRightChildIndex(index);
			}

			if (heap[smallerChildIndex] < heap[index]) {
				swap(smallerChildIndex, index);
				index = smallerChildIndex;
			} else {
				break;
			}
		}

	}


	public static void main(String[] args) {
		MinHeap heap = new MinHeap(10);

		heap.add(10);
		heap.add(20);
		heap.add(30);
		heap.add(1);


		System.out.println("Min value : " + heap.poll());

		System.out.println("Min value : " + heap.poll());

		System.out.println("Min value : " + heap.poll());


		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		priorityQueue.add(10);
		priorityQueue.add(20);
		priorityQueue.add(30);
		priorityQueue.add(1);


		System.out.println("Min value : " + priorityQueue.poll());

		System.out.println("Min value : " + priorityQueue.poll());

		System.out.println("Min value : " + priorityQueue.poll());


	}

}
