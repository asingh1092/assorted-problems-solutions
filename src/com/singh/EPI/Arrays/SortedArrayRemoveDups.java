package com.singh.EPI.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortedArrayRemoveDups {
	
	public static int sortedArrayRemoveDups(List<Integer> A) {
		int writeIndex = 1;
		if (A.isEmpty()) {
			return 0;
		}
		
		for (int i = 1; i < A.size(); ++i) {
			if (!A.get(writeIndex - 1).equals(A.get(i))) {
				A.set(writeIndex++, A.get(i));
			}
		}
		return writeIndex;
	}

	public static void main(String[] args) {
		List<Integer> A = new ArrayList<Integer>();
		Random rand = new Random();
		int randNum;
		for (int i = 1; i < 50; i++) {
			randNum = rand.nextInt(256);
			A.add(randNum);
		}
		System.out.println(sortedArrayRemoveDups(A));

	}

}
