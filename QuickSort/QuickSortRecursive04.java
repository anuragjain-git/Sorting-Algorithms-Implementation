package QuickSort;

import java.util.Arrays;

// Taking Random element as Pivot

public class QuickSortRecursive04 {

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
        // Randomly select a pivot element
        int randomIndex = low + (int) (Math.random() * (high - low + 1));
        int pivot = arr[randomIndex];
        swap(arr, randomIndex, high);
        
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                // Swap elements less than the pivot to the left side
                swap(arr, i, j);
                i++;
            }
        }
        // Place the pivot in its correct position
        swap(arr, i, high);
        return i;
    }
    
    // Function to swap
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array is : "+Arrays.toString(arr));
    }
}


//O(n log n) on average and O(n ^ 2) in the worst case

