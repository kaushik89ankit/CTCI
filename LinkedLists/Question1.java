/*

Problem : Remove duplicates from an unsorted linked list

Remove Dups

Assumption : Singly linked list

*/
import java.util.*;

public class Question1 {

	static void removeDups(LinkedList list) {

		Node index = list.head;
		HashSet<Integer> set = new HashSet<>();

		set.add(index.data);

		while (index.next != null) {
			if (set.contains(index.next.data)) {
				index.next = index.next.next;
				continue;
			}
			set.add(index.next.data);
			index = index.next;
		}
	}


	static void removeDupsWithoutBuffer(LinkedList list) {

		Node firstRunner = list.head;



		while (firstRunner != null) {

			Node secondRunner = firstRunner;

			while (secondRunner.next != null) {
				if (secondRunner.next == null) {
					break;
				}
				if (firstRunner.data == secondRunner.next.data) {
					secondRunner.next = secondRunner.next.next;
				} else {
					secondRunner = secondRunner.next;
				}

			}
			firstRunner = firstRunner.next;

		}
	}


	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list.add(5);
		list.add(5);
		list.add(5);
		list.add(10);
		list.add(89);
		list.add(100);
		list.add(100);
		list.add(100);
		list.add(100);
		list.add(100); list.add(100);

		list.print();
		removeDups(list); // Using HashSet
		removeDupsWithoutBuffer(list); // Using Runners Technique
		System.out.println("\nList after removing duplicates : ");
		list.print();
	}
}



// By using HashSet
// Space Complexity = o(N)
// Time Complexity = O(N)


// By using Runners

// Space Comlexity = O(1)

// Time Complexity = O(NxN)