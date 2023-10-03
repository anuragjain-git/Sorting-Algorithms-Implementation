package SelectionSort;

public class SelectionSortRecursive {

	public static void recSelectionSort(int[] arr, int i, int n) {

		int minIndex = i;
		for (int j = i + 1; j < n; j++) {

			// if arr[j] is less, then it is the new minimum
			if (arr[j] < arr[minIndex])
				minIndex = j; // update the index of minimum element
		}

		// Swapping minNumber with i'th index
		int minNumber = arr[minIndex];
		arr[minIndex] = arr[i];
		arr[i] = minNumber;
		
		// Recursive call to find next minimum integer
		if (i + 1 < n)
			recSelectionSort(arr, i + 1, arr.length);
	}

	public static void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = { 2, -4, 3, -1, 6, 0 };
		System.out.print("Before Sorting : ");
		printArray(arr);
		recSelectionSort(arr, 0, arr.length);
		System.out.print("After Sorting  : ");
		printArray(arr);
	}
}


//Running Time

//T(n) = O(n ^ 2)
