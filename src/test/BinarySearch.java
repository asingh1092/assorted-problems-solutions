package test;

public class BinarySearch {

	public static int binarySearch(int[] array, int p, int r, int x) {
		
		if (r >= p) {
			int mid = p + (r - p) / 2;
			if (array[mid] == x) {
				return mid;
			}
			if (array[mid] > x) {
				return binarySearch(array, p, mid - 1, x);
			} else {
				return binarySearch(array, mid + 1, r, x);
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 4, 8, 3, 10};
		int p = 0;
		int r = array.length - 1;
		int x = 8;
		System.out.println(binarySearch(array, p, r, x));
		
	}
}
