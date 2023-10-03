package BubbleSort;

public class BubbleSortOptimize {

    // Function to perform Bubble Sort with optimization
    public static void bubbleSort(int arr[], int size) {
        boolean checkSwap; // Flag to check if any swap is made during a pass
        for (int i = 0; i < size - 1; i++) {
            checkSwap = false; // Initialize the swap flag for this pass
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    checkSwap = true; // Set the flag if a swap is made
                }
            }
            if (!checkSwap) {
                // If no swap is made in this pass, the array is already sorted
                break;
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

        // Call the bubbleSort function to sort the array with optimization
        bubbleSort(arr, size);

        // Print the sorted array
        printArray(arr, size);
    }
}


//Time complexity for this code is still O(n ^ 2) in the worst case.

