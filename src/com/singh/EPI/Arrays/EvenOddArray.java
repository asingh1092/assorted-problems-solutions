package com.singh.EPI.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EvenOddArray {
	
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

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(3);
		list.add(0);
		list.add(23);
		list.add(8);
		list.add(32);
		System.out.println(evenOdd(list));
	}

}
