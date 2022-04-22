/*

Problem : Sum lists - Two numbers are given as linked lists in which digits are stored in reverse order.
				Implement an alogorithm to add the above numbers and return as list;

Input : (7 -> 1 -> 6) + (5 -> 9 -> 2) = 617 + 295 = 912 -> (2 -> 1 -> 9)
Assumption : Numbers can be represented as int


(head -> Node -> Node -> tail)
*/


public class Question5 {



	public static void main(String[] args) {

		LinkedList list1 = new LinkedList();

		list1.add(6);
		list1.add(1);
		list1.add(7);

		System.out.println("List1 : \n " );
		list1.print();

		LinkedList list2 = new LinkedList();

		list2.add(2);
		list2.add(9);
		list2.add(5);

		System.out.println("\nList2 : \n " );
		list2.print();

//	LinkedList sumList = sumList(list1,list2);
		LinkedList sumList = recursiveSumList(list1, list2);
		System.out.println("\nAfter Sum : \n");

		sumList.print();

	}


	static LinkedList recursiveSumList(LinkedList list1 , LinkedList list2) {

		Node head = addLists(list1.head , list2.head , 0);

		LinkedList result = new LinkedList();

		result.head = head;

		return result;
	}

	static Node addLists(Node head1 , Node head2 , int carryOver) {

		if ((head1 == null) && (head2 == null) && (carryOver == 0)) {
			return null;
		}


		int value = carryOver;
		if (head1 != null) {
			value += head1.data;
		}

		if (head2 != null) {
			value += head2.data;
		}


		carryOver = value / 10;
		Node result = new Node(value % 10);


		if ((head1 != null) || (head2 != null)) {
			Node nextNode = addLists(head1 == null ? null : head1.next , head2 == null ? null : head2.next , carryOver);

			result.next = nextNode;
		}

		return result;

	}


	static LinkedList sumList(LinkedList list1 , LinkedList list2) {

		LinkedList list = new LinkedList();
		Node current = null;
		Node current1 = list1.head;
		Node current2 = list2.head;


		int carryOver = 0;
		while (current1 != null && current2 != null) {
			int sum = current1.data + current2.data + carryOver;

			if (sum / 10 > 0) {
				carryOver = sum / 10;
				sum = sum % 10;
			} else {
				carryOver = 0;
				sum = sum % 10;
			}
			Node result = new Node(sum);
			if (list.head == null) {
				list.head = result;
				current = result;
			} else {
				current.next = result;
				current = result;
			}
			current1 = current1.next;
			current2 = current2.next;
		}


		if (current1 == null) {
			while (current2 != null) {
				current.next = new Node(current2.data);
				current = current.next;
				current2 = current2.next;
			}
		} else if (current2 == null) {
			while (current1 != null) {
				current.next = new Node(current1.data);
				current1 = current1.next;
				current = current.next;
			}
		}

		return list;
	}


}


