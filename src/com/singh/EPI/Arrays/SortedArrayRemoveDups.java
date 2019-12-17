package com.singh.EPI.Arrays;

import java.util.ArrayList;
import java.util.List;

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
		A.add(2);
		A.add(2);
		A.add(2);
		A.add(3);
		A.add(4);
		A.add(5);
		System.out.println(sortedArrayRemoveDups(A));

	}

}
