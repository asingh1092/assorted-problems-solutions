package com.singh.CrTCI.test;

import java.util.HashSet;

public class FindSmallestPositiveNumberMissing {
	
	static int missingNumber(int[] values) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int n : values) {
			if (n > 0) {
				set.add(n);
			}
		}
		
		for (int i = 1; i <= values.length + 1; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}
		
		return 1;
	}

}
