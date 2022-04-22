/*

Problem : Implement an algorithm to find the Kth to last element of singly Linked List

*/


public class Question2{

	static int findKthLastElement(LinkedList list,int k){

		if((k <=  0) || (list.head == null)){
			return 0;
		}
		Node current = list.head;

		Node runner = current;


		for(int i = 0 ; i < k ; i++){
			runner = runner.next;
			if(runner == null){
				return 0;
			}
		}

		while(runner.next != null){
			runner = runner.next;
			current = current.next;
		}

		return current.next.data;

// 100 --> 200 ---> 300 ----> 400
	}


	public static void main(String[] args) {
		

		LinkedList list = new LinkedList();
		list.add(5);
//		list.add(5);
//		list.add(5);
		list.add(10);
		list.add(89);
		list.add(100);
//		list.add(100);
//		list.add(100);
//		list.add(100);
//		list.add(100);
		list.add(93);

		list.print();

		int result = findKthLastElement(list,78889);

		System.out.println("Result : " + result);

	}
}


// Time Complexity = O(N)

// Space Complexity = O(1)2