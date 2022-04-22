/*

Problem : Palindrome - Implement a function to check if a list is palindrome

*/


// Reverse and Compare


public class Question6{


	static boolean isPalindrome(LinkedList list){

		LinkedList reversed = reverseAndClone(list);

		return isEqual(reversed , list);
	}

	static LinkedList reverseAndClone(LinkedList list){

		LinkedList reversed = new LinkedList();

		Node current = list.head ;

		while(current != null){
			reversed.add((current.data));
			current = current.next;
		}

		return reversed;
	}

	static boolean isEqual(LinkedList list1 , LinkedList list2){

		Node current1 = list1.head;

		Node current2 = list2.head;


		while((current1 != null) || (current2 != null)){

			if(current1.data != current2.data){
				return false;
			}
			current2  = current2.next;
			current1 = current1.next;
		}


		return (current1 == null) && (current2 == null);
	}




	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		list.add(5);
		list.add(10);
		list.add(89);
		list.add(100);
		list.add(100);
		list.add(89);
		list.add(10);
		list.add(5);

		list.print();

		System.out.println("\nThe given list is palindrome ? " + isPalindrome(list));


	}
}


