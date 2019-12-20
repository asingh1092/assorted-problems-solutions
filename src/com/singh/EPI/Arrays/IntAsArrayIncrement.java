package com.singh.EPI.Arrays;

import java.util.ArrayList;
import java.util.List;

public class IntAsArrayIncrement {

	public static List<Integer> incrementArray1(List<Integer> A) {
		int carry = 0;
		for (int i = A.size() - 1; i == 0; i--) {
			if (carry > 1) {
				
			}

			if (A.get(i) + 1 == 10) {
				A.set(i, 0);
				carry = 1;
			}
		}

		return A;
	}
	
	public static List<Integer> incrementArray(List<Integer> A) {
		int n = A.size() - 1; // 
		A.set(n, A.get(n) + 1);
		
		for (int i = n; i > 0 && A.get(i) == 10; i--) {
			A.set(i, 0);
			A.set(i - 1, A.get(i - 1) + 1);
		}
		
		if (A.get(0) == 10) {
			A.set(0,  1);
			A.add(0);
		}

		return A;
	}
	
	public static void main(String args[]) {
		List<Integer> test1 = new ArrayList<>();
		List<Integer> test2 = new ArrayList<>();
		List<Integer> test3 = new ArrayList<>();
		List<Integer> test4 = new ArrayList<>();
		
		test1.add(9);
		test2.add(1); test2.add(9); test2.add(9);
		test3.add(1); test3.add(2); test3.add(9);
		test4.add(1); test4.add(2); test4.add(8);
		
		System.out.println(incrementArray(test1));
		System.out.println(incrementArray(test2));
		System.out.println(incrementArray(test3));
		System.out.println(incrementArray(test4));
	}
}
