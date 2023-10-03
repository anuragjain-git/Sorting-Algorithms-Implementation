package InsertionSort;

public class InsertionSortRecursive {

	public static void insertionSort(int arr[],int size) {
		
		//base case
		if(size <= 1)
			return;
		
		//sort first size - 1 element recursively
		insertionSort(arr, size - 1);
		
		// insert the last element at its correct position in the sorted array
        int last = arr[size-1];
        int j = size-2;
        
        while(j >= 0 && arr[j] > last) {
        	arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = last;
	}
	
	public static void printArray(int arr[],int size) {
		for(int i = 0; i < size; i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public static void main(String[] args) {
		int arr[] = {60,30,-20,50,40,-10};
		int size = arr.length;
		insertionSort(arr, size);
		printArray(arr, size);
	}
}

// Running Time

// T(n) = (n - 1) + (n - 2) + (n - 3)+ . . . . + 2 + 1
// T(n) = (n * (n  - 1) / 2)
// T(n) = O(n^2)


//Best Video on this  :  https://youtu.be/uwV80JaZrPs