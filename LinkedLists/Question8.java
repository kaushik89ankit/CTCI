/*

Problem : Loop Detection - Given a circular linked list , return the node at the beginning of the loop

*/


public class Question8 {




	public static void main(String[] args) {


		LinkedList list = new LinkedList();
		list.add(5);
		list.add(10);
		list.add(89);
		list.add(100);
		list.add(25);
		list.add(35);
		list.add(45);
		list.add(55);
		list.add(65);
		list.print();

		list.add(list.head.next.next.next);

		//list.print();

		Node startOfLoop = isCircularLinkedList(list);

		if (startOfLoop != null) {
			System.out.println("The linked  list is circular with loop starting on Node which has value : " + startOfLoop.data);
		} else {
			System.out.println("The linked list has no circular loop");
		}
	}


	static Node isCircularLinkedList(LinkedList list) {

		Node fastRunner = list.head;
		Node slowRunner = list.head;


		while((fastRunner != null) && (fastRunner.next != null)){

			fastRunner = fastRunner.next.next;
			slowRunner = slowRunner.next;

			if(fastRunner == slowRunner){
				break;
			}
		}

		// No meeting point thus not a circular linked list
		if ((fastRunner == null)|| (fastRunner.next == null)) {
			return fastRunner;
		}

		fastRunner = list.head;

		while (fastRunner != slowRunner) {
			fastRunner = fastRunner.next;
			slowRunner = slowRunner.next;
		}

		return fastRunner;
	}
}