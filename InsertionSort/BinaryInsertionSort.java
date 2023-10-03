package InsertionSort;

public class BinaryInsertionSort {

	// Return location where item should be inserted
	public static int binarySearch(int arr[], int item, int low, int high) {
		while(low <= high) {
			int mid = (low + high) / 2;
			if(item == mid)
				return mid + 1;
			else if(item > arr[mid])
				low = mid + 1;
			else
				high = mid - 1;
		}
		return low;
	}
	
	public static void binaryInsertionSort(int arr[], int size) {
		for(int i = 1; i < size; i++) {
			int j = i - 1;
			int item = arr[i];
			int location = binarySearch(arr, item, 0, j);
			
			// Move all elements after location to create space for item
			while(j >= location) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			
			//insert the item at the location
			arr[j + 1] = item;
		}
		
	}
	
	public static void printArray(int arr[],int size) {
		for(int i = 0; i < size; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {3,7,4,5,6,2,1};
		int size = arr.length;
		binaryInsertionSort(arr, size);
		printArray(arr, size);
	}

}

// Time Complexity

// T(n) = n * (BinarySearch + Shifting)
// T(n) = n * (O(log n) + O(n))
// T(n) = O(n*log n) + O(n^2)
// T(n) = O(n^2)


// :: https://www.youtube.com/watch?v=-OVB5pOZJug

