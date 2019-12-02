package test;

import java.util.Arrays;

public class MergeSort {

	public static void mergeSort(int[] array, int p, int r) {
		if (r > p) {
			int mid = (p + r) / 2;
			mergeSort(array, p, mid);
			mergeSort(array, mid + 1, r);
			merge(array, p, mid, r);
		}
	}

	public static void merge(int[] array, int p, int mid, int r) {
		int lowSize = mid - p + 1;
		int highSize = r - mid;

		int[] lowSubArray = new int[lowSize];
		int[] highSubArray = new int[highSize];

		for (int i = 0; i < lowSize; i++) {
			lowSubArray[i] = array[p + i];
		}
		for (int j = 0; j < highSize; j++) {
			highSubArray[j] = array[mid + 1 + j];
		}

		int i = 0;
		int j = 0;
		int k = p;
		while (i < lowSize && j < highSize) {
			if (lowSubArray[i] <= highSubArray[j]) {
				array[k] = lowSubArray[i];
				i++;
			} else {
				array[k] = highSubArray[j];
				j++;
			}
			k++;
		}

		while (i < lowSize) {
			array[k] = lowSubArray[i];
			i++;
			k++;
		}
		while (j < highSize) {
			array[k] = highSubArray[j];
			j++;
			k++;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {0, 2, 23, 95, 45, 9};
		mergeSort(array, 0, array.length -1);
		System.out.print(Arrays.toString(array));
	}
}
