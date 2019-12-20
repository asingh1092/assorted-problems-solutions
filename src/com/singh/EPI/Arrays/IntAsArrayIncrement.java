package com.singh.EPI.Arrays;

import java.util.List;

public class IntAsArrayIncrement {

	public static List<Integer> incremeentArray(List<Integer> A) {
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

}
