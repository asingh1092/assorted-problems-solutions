package com.singh.EPI.Arrays;

import java.util.ArrayList;
import java.util.List;

public class IntAsArrayMultiply {

	public static List<Integer> intAsArrayMultiply(List<Integer> A, List<Integer> B) {
		List<Integer> result = new ArrayList<>();
		int longerOfTheTwoSize;
		if (B.size() < A.size()) {
			longerOfTheTwoSize = A.size();
		} else {
			longerOfTheTwoSize = B.size();
		} 
		int carry;
		for (int i = longerOfTheTwoSize - 1; i >= 0 ; i++) {
			result.add((int) Math.floor(A.get(i) * B.get(i)));
			if (-1 < A.get(i) * B.get(i) / 10 && A.get(i) * B.get(i) / 10  < 1) {
				result.add((int) Math.floor(A.get(i) * B.get(i)) / 10);
				carry = (int) Math.floorDiv(A.get(i), B.get(i));
			} else {
				carry = (int) Math.floorDiv(A.get(i), B.get(i));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
