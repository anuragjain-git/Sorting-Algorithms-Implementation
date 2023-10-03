package QuickSort;

import java.util.Arrays;
import java.util.Stack;

public class QuickSortStack {
    public static void quickSort(int[] arr, int low, int high) {
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);

        while (!stack.isEmpty()) {
            // Pop low and high values from the stack
            high = stack.pop();
            low = stack.pop();

            // Perform partitioning
            int pivotIndex = partition(arr, low, high);

            // Push subarray indices to the stack for further processing
            if (pivotIndex - 1 > low) {
                stack.push(low);
                stack.push(pivotIndex - 1);
            }

            if (pivotIndex + 1 < high) {
                stack.push(pivotIndex + 1);
                stack.push(high);
            }
        }
    }

    public static int partition(int[] arr, int low, int high) {
    	 // Choosing last element as pivot element
        int pivot = arr[high];
        int i = low - 1;

        // Traverse through the array and rearrange elements around the pivot
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                // Swap elements if they are smaller than the pivot
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap the pivot element into its correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Return the index of the pivot element
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        int n = arr.length;

        // Sort the array using iterative Quick Sort
        quickSort(arr, 0, n - 1);

        // Print the sorted array
        System.out.println("Sorted Array is : "+Arrays.toString(arr));
    }
}


//O(n log n) on average and O(n ^ 2) in the worst case
