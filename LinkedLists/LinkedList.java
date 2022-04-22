/*
LinkedList class for practice

*/

public class LinkedList{

Node head;


boolean add(int data){

	Node node = new Node(data);

	if(head == null){
		head = node;
		return true;
	}
	node.next = head;
	head = node;

	return true;
}


boolean add(Node node){

	if(head == null){
		head = node;
		return true;
	}
	Node current = head;

	while(current.next != null){
		current = current.next;
	}

	current.next = node;
	return true;
}

void print(){

	if(head == null){
		return;
	}
	Node index = head ;

	while(index != null){
		System.out.println(index.toString());
		index = index.next;
	}
}

Node delete(int data){

	if(head == null){return head;}

	Node index = head ;

	if(index.data == data){ 
		head = head.next;
		return head;}


	while(index.next != null){
		if(index.next.data == data){
			index.next = index.next.next;
			return head;
		}		
		index = index.next;
}
	return head;
}


public static void main(String[] args) {
	
}

}

class Node {

	 int data;
	 Node next;

	public Node(int data){
		this.data = data;
	}


	public String toString(){
		return "Data : " + data ;
	}

}




