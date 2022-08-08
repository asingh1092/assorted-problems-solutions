package src.com.singh.Rando;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorting {

    /**
     * Takes an unsorted list of elements and moves the smallest element
     * to the front of the unsorted list.
     *
     * @param unsorted unsorted array
     */

    public void selectionSort(int[] unsorted) {
        int size = unsorted.length;
        int min_idx;
        for (int i = 0; i < size - 1; i++) {
            min_idx = i;
            for (int j = i + 1; j < size; j++) {
                // check if smallest
                if (unsorted[j] < unsorted[min_idx]) {
                    min_idx = j;
                }
            }
            // Swap the two
            int temp = unsorted[min_idx];
            unsorted[min_idx] = unsorted[i];
            unsorted[i] = temp;
        }
    }

    /**
     * Takes an unsorted list of elements and moves the smallest element
     * to the front of the unsorted list.
     *
     * @param unsorted unsorted array of type T
     */

    public void selectionSort(List<Integer> unsorted) {
        int size = unsorted.toArray().length;
        int min_idx;
        for (int i = 0; i < size - 1; i++) {
            min_idx = i;
            for (int j = i + 1; j < size; j++) {
                // check if smallest
                if (unsorted.get(j) < unsorted.get(min_idx)) {
                    min_idx = j;
                }
            }
            // Swap the two
            Collections.swap(unsorted, min_idx, i);
        }
    }

    /**
     * Sort the unsorted array using insertion sort.
     *
     * @param unsorted array
     */
    public void insertionSort(int[] unsorted) {
        int n = unsorted.length;
        for (int i = 1; i < n; ++i) {
            int key = unsorted[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && unsorted[j] > key) {
                unsorted[j + 1] = unsorted[j];
                j = j - 1;
            }
            unsorted[j + 1] = key;
        }
    }

    public void quickSort() {

    }

    public static void main(String[] args) {
        int[] test1 = new int[]{3, 6, -2, 4, 2, 86, 23, -20};
        Sorting sorting = new Sorting();
        sorting.selectionSort(test1);
        List<Integer> test2 = Arrays.asList(3, 6, -2, 4, 2, 86, 23, -20);
        sorting.selectionSort(test2);
        System.out.println(Arrays.toString(test1));
        System.out.println(test2);
    }
}
