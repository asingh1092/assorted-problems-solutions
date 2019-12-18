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
		System.out.println(evenOdd(list));
		System.out.println(evenOddMoreSpace(list));
	}

}
