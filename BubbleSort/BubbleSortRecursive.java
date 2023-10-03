package BubbleSort;

public class BubbleSortRecursive {
	
	// Function to perform Bubble Sort recursively
	public static void bubbleSort(int arr[], int size) {
		boolean sorted;
		for (int i = 0; i < size - 1; i++) {
			sorted = true;
			for (int j = 0; j < size - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					sorted = false;
				}
			}
			if (!sorted) {
				// If any swap is made in this pass, recursively call bubbleSort
				bubbleSort(arr, size);
			}
		}
	}
	
	// Function to print the sorted array
	public static void printArray(int arr[], int size) {
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		int arr[] = {60, 30, -20, 50, 40, -10};
		int size = arr.length;
		
		// Call the bubbleSort function to sort the array recursively
		bubbleSort(arr, size);
		
		// Print the sorted array
		printArray(arr, size);
	}
}


// Time complexity for this code is still O(n ^ 2) in the worst case.

