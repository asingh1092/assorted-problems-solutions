package test;

import java.util.Arrays;

public class Problem2 {

	/*
	 * Check Permutation: Given two strings, write a method to decide if one is a
	 * permutation of the other
	 */
	
	public boolean isPermutation(String str1, String str2) {
		char[] chArray1 = str1.toCharArray();
		char[] chArray2 = str2.toCharArray();
		Arrays.sort(chArray1);
		Arrays.sort(chArray2);
		for (int i = 0; i < chArray1.length; i++) {
			if (chArray1[i] != chArray2[i]) {
				return false;
			}
		}
		return true;
	}
	
}
