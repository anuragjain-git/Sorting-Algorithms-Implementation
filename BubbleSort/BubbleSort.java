package BubbleSort;

public class BubbleSort {
	
	// Function to perform Bubble Sort
	public static void bubbleSort(int arr[], int size) { 
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
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
		
		// Call the bubbleSort function to sort the array
		bubbleSort(arr, size);
		
		// Print the sorted array
		printArray(arr, size);
	}
}

// T(n) = O(n ^ 2)