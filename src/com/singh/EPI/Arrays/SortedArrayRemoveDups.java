package com.singh.EPI.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SortedArrayRemoveDups {
	
	public static int sortedArrayRemoveDups(List<Integer> A) {
		Collections.sort(A);
		System.out.println("Input Array: " + A);
		int writeIndex = 1;
		if (A.isEmpty()) {
			return 0;
		}

		for (int i = 1; i < A.size(); ++i) {
			if (!A.get(writeIndex - 1).equals(A.get(i))) {
				A.set(writeIndex++, A.get(i));
			}
		}
		System.out.println("Output Array: " + A.subList(0, writeIndex));

		return writeIndex;
	}

	public static void main(String[] args) {
		List<Integer> A = new ArrayList<Integer>();
		Random rand = new Random();
		int randNum;
		for (int i = 1; i < 10; i++) {
			randNum = rand.nextInt(5);
			A.add(randNum);
		}
		System.out.println(sortedArrayRemoveDups(A));

	}

}
