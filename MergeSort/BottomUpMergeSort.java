// Iterative MergeSort

package MergeSort;

public class BottomUpMergeSort {

	static void merge(int arr[], int left, int mid, int right) {
	    // Find sizes of two subarrays to be merged
		
	    int n1 = mid - left + 1; // Size of the left subarray (n1)
	    int n2 = right - mid;    // Size of the right subarray (n2)

	    // Create temp arrays
	    int L[] = new int[n1]; // Temporary array for the left subarray
	    int R[] = new int[n2]; // Temporary array for the right subarray

	    // Copy data to temp arrays
	    for (int i = 0; i < n1; i++)
	        L[i] = arr[left + i]; // Copy elements from the left subarray
	    for (int j = 0; j < n2; j++)
	        R[j] = arr[mid + 1 + j]; // Copy elements from the right subarray

	    // Merge the temp arrays

	    // Initial indexes of first and second subarrays
	    int i = 0, j = 0;

	    // Initial index of the merged subarray (arr)
	    int k = left;

	    // Merge elements from L[] and R[] back into arr[]
	    while (i < n1 && j < n2) {
	        if (L[i] <= R[j]) {
	            arr[k] = L[i]; // Copy an element from L[] to arr[]
	            i++; // Move to the next element in L[]
	        } else {
	            arr[k] = R[j]; // Copy an element from R[] to arr[]
	            j++; // Move to the next element in R[]
	        }
	        k++; // Move to the next position in arr[]
	    }

	    // Copy remaining elements of L[] if any
	    while (i < n1) {
	        arr[k] = L[i]; // Copy remaining elements from L[] to arr[]
	        i++;
	        k++;
	    }

	    // Copy remaining elements of R[] if any
	    while (j < n2) {
	        arr[k] = R[j]; // Copy remaining elements from R[] to arr[]
	        j++;
	        k++;
	    }
	}

	// Function that sorts arr[]
	static void sort(int arr[], int left, int right) {
		if (left < right) {
			// Find the middle point
			int mid = left + (right - left) / 2;

			// Sort first and second halves
			sort(arr, left, mid);
			sort(arr, mid + 1, right);

			// Merge the sorted halves
			merge(arr, left, mid, right);
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

		sort(arr, 0, arr.length - 1);

		System.out.print("Sorted array : ");
		printArray(arr);
	}

}

//Running Time : T(n) = O(n * log n)

// https://www.youtube.com/watch?v=xleF7ykgcHY
