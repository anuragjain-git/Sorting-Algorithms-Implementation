package InsertionSort;

public class InsertionSortSingleLinkedList{
	Node head;
	Node sorted;

	class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
//			this.next = null;
		}
	}

	// Insert into the list
	void push(int value) {
		Node newnode = new Node(value);
		// point new node to the head
		newnode.next = head;
		// move head to point to the new node
		head = newnode;
	}

	// Print linked list
	void printlist(Node head) {
		Node current = head;
		while (current != null) {
			System.out.print(current.value + " ");
			current = current.next;
		}
	}

	// Insertion sort
	void insertionSort(Node headref) {
		// Initially the sorted linked list is null
		sorted = null;
		Node current = headref;
		while (current != null) {
			/*
			 * Current value will be added to sorted linked list so store current.next value
			 * to next, for next iteration
			 */
			Node next = current.next;
			// Insert current in sorted linked list
			sortedInsert(current);
			// Update current value for next iteration
			current = next;
		}
		// Point head to sorted linked list
		head = sorted;
	}

	// Insert current as newnode node to the sorted linked list
	void sortedInsert(Node newnode) {
		/*
		 * Initially the sorted linked list is null so first insertion will point to
		 * sorted
		 */
		if (sorted == null || sorted.value >= newnode.value) {
			// Point newnode to sorted and update sorted to newnode
			newnode.next = sorted;
			sorted = newnode;
		} else {
			Node current = sorted;
			// Locate the node before insertion in the sorted linked list
			while (current.next != null && current.next.value < newnode.value) {
				current = current.next;
			}
			// Insert the new node into the sorted linked list

			// Point newnode to the node where node before insertion is pointing
			newnode.next = current.next;
			// point the node before insertion to newnode
			current.next = newnode;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertionSortSingleLinkedList list = new InsertionSortSingleLinkedList();
		list.push(-1);
		list.push(2);
		list.push(-3);
		list.push(1);

		System.out.println("Linked List before Sorting");
		list.printlist(list.head);
		list.insertionSort(list.head);
		System.out.println("\nLinkedList After sorting");
		list.printlist(list.head);
	}

}

// Running Time
// For n nodes we may traverse n times in sorted linked list

// T(n) = O(n ^ 2)