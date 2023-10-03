package SelectionSort;

public class SelectionSort {

	public static void selectionSort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {

				// if arr[j] is less, then it is the new minimum
				if (arr[j] < arr[minIndex])
					minIndex = j; // update the index of minimum element
			}

			// Swapping minNumber with i'th index
			int minNumber = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = minNumber;
		}
	}

	public static void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int arr[] = { -9, 3, 2, 5, -7, -1, 0 };
		System.out.print("Before Sorting : ");
		printArray(arr);
		selectionSort(arr);
		System.out.print("After Sorting  : ");
		printArray(arr);
	}

}

// Running Time

// T(n) = O(n ^ 2)
