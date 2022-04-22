/*

Problem : Delete Middle Node - Delete a node , not first or last , given access to only that Node


*/

public class Question3{

	// Wrong in the sense that instead of shifting whole linked list , copy next node to current one and delete the nenxt one.
	static void removeMiddleNode(Node node){

		Node temp = node;
		while(temp.next.next != null){
		temp.data = temp.next.data;
		temp = temp.next;
		}
		temp.data = temp.next.data;
		temp.next = null;
	}

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		list.add(5);
		list.add(10);
		list.add(89);
		list.add(100);
	
		list.print();

		removeMiddleNode(list.head.next.next);
		System.out.println("\nAfter operation : \n");
		list.print();
	}
}