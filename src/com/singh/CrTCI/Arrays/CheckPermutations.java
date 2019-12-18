package com.singh.CrTCI.Arrays;

import java.util.Arrays;

public class CheckPermutations {
	
	
	public static boolean checkPermutation(String word1, String word2) {
		int wLength1 = word1.length();
		int wLength2 = word2.length();
		
		if (wLength1 != wLength2) {
			return false;
		}
		
		char[] cWord1 = new char[wLength1];
		cWord1 = word1.toCharArray();
		char[] cWord2 = new char[wLength2];
		cWord2 = word2.toCharArray();
		
		Arrays.sort(cWord1);
		Arrays.sort(cWord2);
		
		for (int i = 0; i < cWord1.length; i++) {
			if (cWord1[i] != cWord2[i]) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		System.out.println(checkPermutation("test", "estt"));
		System.out.println(checkPermutation("test", "estt1"));
		System.out.println(checkPermutation("test1", "estt2"));
		System.out.println(checkPermutation("momm", "mmom"));
	}

}
