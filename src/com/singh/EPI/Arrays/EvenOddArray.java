package com.singh.EPI.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EvenOddArray {

	// Time: O(n)
	// Space: O(1)
	public static List<Integer> evenOdd(List<Integer> A) {
		int nextEven = 0;
		int nextOdd = A.size() - 1;

		while (nextEven < nextOdd) {
			if (A.get(nextEven) % 2 == 0) {
				nextEven++;
			} else {
				Collections.swap(A, nextEven, nextOdd--);
			}
		}
		return A;
	}
	
	public static void evenOddStaticArray(int[] arr) {
		int even = 0;
		int odd = arr.length - 1;
		while (even < odd) {
			if (arr[even] % 2 == 0) {
				even++;
			} else {
				swap(arr, even, odd--);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " , ");
		}
	}

	private static void swap(int[] arr, int even, int odd) {
		int temp = arr[even];
		arr[even] = arr[odd];
		arr[odd] = temp;
	}

	// Time: O(n)
	// Space: O(n)
	public static List<Integer> evenOddMoreSpace(List<Integer> A) {
		List<Integer> evenList = new ArrayList<>();
		List<Integer> oddList = new ArrayList<>();
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) % 2 == 0) {
				evenList.add(A.get(i));
			} else {
				oddList.add(A.get(i));
			}
		}

		int index = 0;
		while (!evenList.isEmpty()) {
			A.set(index, evenList.get(0));
			evenList.remove(0);
			index++;
		}

		while (!oddList.isEmpty()) {
			A.set(index, oddList.get(0));
			oddList.remove(0);
			index++;
		}

		return A;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i <= 101; i++) {
			list.add(i);
		}
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(evenOdd(list));
		evenOddStaticArray(arr);
		System.out.println(evenOddMoreSpace(list));
	}

}
