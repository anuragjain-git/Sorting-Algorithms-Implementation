package QuickSort;

import java.util.Scanner;

public class QuickSortLinkedList {
    // Define a nested ListNode class to represent nodes in the linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Function to perform Quick Sort on a linked list.
    public static ListNode quickSort(ListNode head) {
        // Base case: If the list is empty or has only one element, it is already sorted.
        if (head == null || head.next == null) {
            return head;
        }

        // Choose a pivot (e.g., the first element).
        ListNode pivot = head;
        ListNode lessHead = new ListNode(0);
        ListNode less = lessHead;
        ListNode greaterHead = new ListNode(0);
        ListNode greater = greaterHead;

        ListNode current = head.next;

        // Partition the linked list into two sublists: elements less than the pivot and greater than or equal to the pivot.
        while (current != null) {
            if (current.val < pivot.val) {
                less.next = current;
                less = less.next;
            } else {
                greater.next = current;
                greater = greater.next;
            }
            current = current.next;
        }

        // Terminate the two partitions.
        less.next = null;
        greater.next = null;

        // Recursively sort the partitions.
        ListNode sortedLess = quickSort(lessHead.next);
        ListNode sortedGreater = quickSort(greaterHead.next);

        // Combine the sorted partitions and pivot.
        if (sortedLess == null) {
            pivot.next = sortedGreater;
            return pivot;
        } else {
            ListNode tail = sortedLess;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = pivot;
            pivot.next = sortedGreater;
            return sortedLess;
        }
    }

    // Helper function to print a linked list.
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the linked list: ");
        int n = scanner.nextInt();
        
        System.out.println("Enter the elements of the linked list:");

        // Initialize the linked list with user input.
        ListNode head = null;
        ListNode tail = null;
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Display the original linked list.
        System.out.println("Original Linked List:");
        printList(head);

        // Sort the linked list using Quick Sort.
        head = quickSort(head);

        // Display the sorted linked list.
        System.out.println("Sorted Linked List:");
        printList(head);

        scanner.close();
    }
}

// O(n log n) on average and O(n^2) in the worst case