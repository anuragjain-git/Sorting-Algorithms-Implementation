// Recursive MergeSort

package MergeSort;

public class TopDownMergeSort {

	public static void mergeSort(int[] arr) {
		
		int n = arr.length;
		
		if (n > 1) {
			int mid = n / 2;

			// Create temp arrays
			int left[] = new int[mid];
			int right[] = new int[n - mid];

			// Copy data to temp array
			for (int i = 0; i < mid; i++)
				left[i] = arr[i];
			for (int i = mid; i < n; i++)
				right[i - mid] = arr[i];

			mergeSort(left);
			mergeSort(right);

			int i = 0;
			int j = 0;
			int k = 0;

			// Merge left and right arrays
			while (i < left.length && j < right.length) {
				if (left[i] < right[j]) {
					arr[k] = left[i];
					i++;
				} else {
					arr[k] = right[j];
					j++;
				}
				k++;
			}

			// Copy remaining elements of left[] if any
			while (i < left.length) {
				arr[k] = left[i];
				i++;
				k++;
			}

			// Copy remaining elements of right[] if any
			while (j < right.length) {
				arr[k] = right[j];
				j++;
				k++;
			}
		}
	}

	// print array of size n
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = { 1, -1, 0, 2, 4, 3 };

		System.out.print("Given Array  : ");
		printArray(arr);

		mergeSort(arr);

		System.out.print("Sorted array : ");
		printArray(arr);
	}

}


// T(n) = O(n log n)