package MergeSort;
import java.util.Scanner;

class ListNode {
	int val;
	ListNode next;
	
	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

public class MergeSortLinkedList {
	
	// Function to merge two sorted linked lists
    private ListNode merge(ListNode left, ListNode right) {
    	ListNode dummy = new ListNode(-1);
    	ListNode current = dummy;
    	
    	while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
    	
    	// Copy remaining element
    	if (left != null) {
            current.next = left;
        }

        if (right != null) {
            current.next = right;
        }

        return dummy.next;
    }
	
	// Function to perform Merge Sort on a linked list
	public ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		// Find the middle of the linked list
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// Split the linked list into two halves
		ListNode l1 = head;
		ListNode l2 = slow.next; // Start right from the element to the right of mid
		slow.next = null; // Cut the connection between left and right
		

        // Recursively sort the two halves
        ListNode left = mergeSort(l1);
        ListNode right = mergeSort(l2);
        
        // Merge the sorted halves
        return merge(left, right);
	}
	
	// Function to create a linked list from user input
	public ListNode createLinkedList() {
		Scanner sc = new Scanner(System.in);
		ListNode dummy = new ListNode(-1); // dummy node will be pointed to first element
		ListNode current = dummy;
		
		System.out.print("Enter the number of elements: ");
		int n = sc.nextInt();
		
		System.out.println("Enter the elements: ");
		for(int i = 0; i < n; i++) {
			int value = sc.nextInt();
			current.next = new ListNode(value);
			current = current.next;
		}
		
		return dummy.next;
	}
	
	// Function to print linked list
	public void printList(ListNode head) {
		ListNode current = head;
		while(current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MergeSortLinkedList sorter = new MergeSortLinkedList();
		
		// Create a linked list with user input
		ListNode head = sorter.createLinkedList();
		
		System.out.println("Original Linked List: ");
		sorter.printList(head);
		
		// Sort the linked list using Merge Sort
		head = sorter.mergeSort(head);
		
		System.out.println("Sorted Linked List: ");
		sorter.printList(head);
	}

}

// https://www.youtube.com/watch?v=HUFibUCDt0U

// T(n) = O(n log n)