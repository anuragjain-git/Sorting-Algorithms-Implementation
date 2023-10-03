package QuickSort;

import java.util.Arrays;

// Taking first element as Pivot

public class QuickSortRecursive02 {

    public static void quickSort(int[] arr, int low, int high) {
        // Base case: If the low index is less than the high index, continue sorting
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, low, high);
            
            // Recursively sort the subarrays on the left and right of the pivot
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partitioning function
    public static int partition(int[] arr, int low, int high) {
        // Choose the first element as the pivot
        int pivot = arr[low];
        int i = low + 1;
        for (int j = low + 1; j <= high; j++) {
            if (arr[j] < pivot) {
                // Swap elements less than the pivot to the left side
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        // Place the pivot in its correct position
        int temp = arr[low];
        arr[low] = arr[i - 1];
        arr[i - 1] = temp;
        return i - 1;
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array is : "+Arrays.toString(arr));
    }
}


//O(n log n) on average and O(n ^ 2) in the worst case

