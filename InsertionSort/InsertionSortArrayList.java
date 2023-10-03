package InsertionSort;

import java.util.ArrayList;

public class InsertionSortArrayList {

	public static void insertionSort(ArrayList<Integer> list) {
		int size = list.size();

		// Iterate over each element in the list starting from the second element
		for (int i = 1; i < size; i++) {
			int key = list.get(i);
			int j = i - 1;

			/*
			 * Compare the current element with the sorted portion and move elements to the
			 * right
			 */
			while (j >= 0 && list.get(j) > key) {
				list.set(j + 1, list.get(j));
				j--;
			}

			// Insert the key into the correct position in the sorted portion
			list.set(j + 1, key);
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(-1);
		al.add(3);
		al.add(2);

		System.out.println("Before sorting: " + al);

		// Sort the list using insertion sort
		insertionSort(al);

		System.out.println("After sorting: " + al);
	}
}

// Time Complexity

/*
 * There is a loop that iterates over each element in the list (n-1 iterations),
 * and within that loop, there is another loop that compares and shifts elements
 * to the right until the correct position is found.
 */

// T(n) = O(n ^ 2)
