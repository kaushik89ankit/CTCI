/*

Problem : Intersection - Determine if two singly linked lists are intersecting. If they are intersecting ,
						 return the itersecting node.

*/


public class Question7 {


	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list.add(5);
		list.add(10);
		list.add(89);
		list.add(100);
		list.print();
		LinkedList list2 = new LinkedList();

		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(list.head.next.next);
		System.out.println("\nAfter intersecting lists : \n");
		list2.print();

		System.out.println("Are these two lists intersecting ? If yes , return the intersecting node");

		IntersectResult result = isIntersecting(list, list2);

		System.out.println("The intersetcing node has result : " + result.result + " with value : " + result.node.data);

	}

	static IntersectResult isIntersecting(LinkedList list1 , LinkedList list2) {

		IntersectResult result = new IntersectResult();

		if (list1.head == null || list2.head == null) {
			return result;
		}

		Node current1 = list1.head;
		int length1 = 1;
		Node current2 = list2.head;
		int length2 = 1;
		while (current1.next != null) {
			current1 = current1.next;
			length1++;
		}

		while (current2.next != null) {
			current2 = current2.next;
			length2++;
		}

		if (current1 != current2) {
			result.result = false;
			return result;
		}

		result.result = true;

		result.node = findIntersectingNode(list1, length1 , list2 , length2);

		return result;

	}

	static Node findIntersectingNode(LinkedList list1 , int length1 , LinkedList list2 , int length2) {

		LinkedList larger = (length1 > length2 ? list1 : list2);
		LinkedList shorter = (larger == list1) ? list2 : list1;

		int difference = (length1 > length2) ? (length1 - length2) : (length2 - length1);

		Node current1 = larger.head;
		Node current2 = shorter.head;

		for(int i = 0 ; i < difference ; i++){
			current1 = current1.next;
		}

		while(current1 != current2){
			current1 = current1.next;
			current2  = current2.next;
		}

		return current1;
	}

}


class IntersectResult {
	Node node;
	boolean result;
}


// Time Complexity = O(A + B)

// Space Complexity = O(1)