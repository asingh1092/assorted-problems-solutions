package test;

import java.util.Arrays;

public class QuickSort {
	
	public static void quickSort(int[] array, int p, int r) {
		if (r > p) {
			int pivot = parition(array, p, r);
			quickSort(array, p, pivot - 1);
			quickSort(array, pivot + 1, r);
		}
	}
	
	public static int parition(int[] array, int p, int r) {
		int pivot = array[r];
		int k = p - 1;
		
		for (int i = p; i < r; i++) {
			if (array[i] <= pivot) {
				k++;
				int temp = array[k];
				array[k] = array[i];
				array[i] = temp;
			}
		}

		int temp = array[k + 1];
		array[k+1] = array[r];
		array[r] = temp;
		return k+1;
	}
	
	public static void main(String[] args) {
		int[] array = {23, 21, 2, 5, 42, 32, 14};
		quickSort(array, 0, array.length -1);
		System.out.println(Arrays.toString(array));
	}
}
