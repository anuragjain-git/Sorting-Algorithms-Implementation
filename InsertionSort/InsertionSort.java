package InsertionSort;

public class InsertionSort {
	
	// Function to perform Insertion Sort
	public static void insertionSort(int arr[], int size) {
		for (int i = 1; i < size; i++) {
			int j = i - 1;
			while (j >= 0 && arr[j] > arr[j + 1]) {
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
				j = j - 1;
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
		
		// Call the insertionSort function to sort the array
		insertionSort(arr, size);
		
		// Print the sorted array
		printArray(arr, size);
	}
	
}


//T(n)= O(n ^ 2) in the worst case.