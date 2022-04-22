/*

Problem : Partition a linked list around value x
Assumption : End result need not be stable
*/


public class Question4 {

	static LinkedList PartitionAround(LinkedList list , int x) {

		LinkedList beforeList = new LinkedList();

		LinkedList afterList = new LinkedList();

		Node current = list.head;

		while (current != null) {
			if (current.data < x) {
				beforeList.add((current.data));
			} else {
				afterList.add((current.data));
			}
			current = current.next;
		}


		return merge(beforeList, afterList);

	}

	static LinkedList merge(LinkedList beforeList , LinkedList afterList) {

		Node current = beforeList.head;

		while (current != null) {
			afterList.add(current.data);
			current = current.next;
		}
//		System.out.println("Just after partition : \n");
//		afterList.print();
		return afterList;
	}



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

		list = PartitionAround(list , 50);

		System.out.println("\n After Partition :\n");

		list.print();

	}
}