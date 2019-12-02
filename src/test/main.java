package test;

public class main {

	public static void main(String[] args) {
		Problem1 ob1 = new Problem1();
		boolean result1 = ob1.isUnique("wo");
		System.out.println(result1);

		Problem2 ob2 = new Problem2();
		boolean result2 = ob2.isPermutation("word", "spacedorw");
		System.out.println(result2);

		Problem3 ob3 = new Problem3();
		boolean result3 = ob3.isPalindromePermutation("geeksforgeeks");
		System.out.println(result3);

		int arr[] = { -3, -4, 3, 0, 2, 4, 4, 23, 42, -12, 24 };
		System.out.println(min(arr));
		System.out.println(secondMin(arr));
	}

	public static int min(int[] arr) {
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}
	
	public static int secondMin(int[] arr) {
		int min = arr[0];
		int min2 = arr[1];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min2 = min;
				min = arr[i];
			}
			else if (arr[i] < min2) {
				min2 = arr[i];
			}
		}
		return min2;
	}
	/* [10, 2, 4, 6, 11, 15, 24]
	 * [2, 4, 6, 10, 11, 15, 24]
	 * [2, 4, 6, 10] // 4rd smallest is 10 */
	public static int mthMin(int[] arr, int m) {
		int arraySize = arr.length;
		int index = m;
		for (int i = 0; i < arraySize; i++) {
			if (arr[index] > arr[i]) {
				int temp = arr[i];
				arr[index] = arr[temp];
			} else {
				return arr[index];
			}
		}
		return arr[index];
	}
}
