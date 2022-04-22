/*

Problem : Intersection - Determine if two singly linked lists are intersecting. If they are 
						 intersecting ,return the itersecting node.

*/

import java.util.*;
public class IntersectingLinkedList{


public class Node{

	Node next;
	Integer value;


	Node(Integer value){
		this.value = value;
	}
}

static Node findIntersectionViaHashMap(Node head){

	Set<IntersectingLinkedList.Node> set = new HashSet<>();
	IntersectingLinkedList.Node current = head;
	while(current != null){
		if(set.contains(current)){
			return current;
		}
		set.add(current);
		current = current.next;
	}

	return null;

}


public static void main(String[] args) {
	
	IntersectingLinkedList list = new IntersectingLinkedList();

	IntersectingLinkedList.Node head = list.new Node(5);
	IntersectingLinkedList.Node a = list.new Node(6);
	IntersectingLinkedList.Node b = list.new Node(7);
	IntersectingLinkedList.Node c = list.new Node(8);
	IntersectingLinkedList.Node d = list.new Node(9);
	IntersectingLinkedList.Node e = list.new Node(10);

	head.next = a;
	a.next = b;
	b.next = c;
	c.next = d;
	d.next = e;
	e.next = null;

	IntersectingLinkedList.Node intersection = findIntersectionViaHashMap(head);

	if(intersection == null){
		System.out.println("No intersection found");
		return;
	}
	System.out.println("Intersection via HashMap : " + intersection.value);

}


}