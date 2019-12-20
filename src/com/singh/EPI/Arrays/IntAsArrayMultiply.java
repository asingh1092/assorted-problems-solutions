package com.singh.EPI.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class IntAsArrayMultiply {

	public static List<Integer> intAsArrayMultiply(List<Integer> A, List<Integer> B) {
		// Deal with sign -> deal with it at the end
		int sign = 1;
		if (A.get(0) < 0 || B.get(0) < 0) {
			sign = -1;
		}
		A.set(0, Math.abs(A.get(0)));
		B.set(0, Math.abs(B.get(0)));
		
		// Create new list of n+m size
		List<Integer> result = new ArrayList<>(Collections.nCopies(A.size() + B.size(), 0));

		for (int i = A.size() - 1; i >= 0; --i) {
			for (int j = B.size() - 1; j >= 0; --j) {
				result.set(i + j + 1, result.get(i + j + 1) + A.get(i) * B.get(j));
				result.set(i + j, result.get(i + j) + result.get(i + j + 1) / 10);
				result.set(i + j + 1, result.get(i + j + 1) % 10);
			}
		}

		// Deal with leading zeros
		int leadingZero = 0;
		while (leadingZero < result.size() && result.get(leadingZero) == 0) {
			leadingZero++;
		}

		result = result.subList(leadingZero, result.size());
		
		// Deal with empty list
		if (result.isEmpty()) {
			return Collections.emptyList();
		}
		
		// Add sign to first digit in result 
		result.set(0, result.get(0) * sign);
		return result;
	}

	public static void main(String[] args) {
		List<Integer> listA = new ArrayList<>();
		List<Integer> listB = new ArrayList<>();
		Random rand = new Random();

		for (int i = 0; i < 6; i++) {
			listA.add(rand.nextInt(10));
		}
		
		for (int i = 0; i < 3; i++) {
			listB.add(rand.nextInt(10));
		}

		System.out.println(intAsArrayMultiply(listA, listB));
	}

}
