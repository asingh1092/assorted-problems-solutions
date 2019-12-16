package com.singh.CrTCI.Arrays;

import java.io.*;
import java.util.*;

public class Problem2_checkPermutation {

	/*
	 * Given two strings write a method to decide if one is a permutation of another
	 */

	static boolean checkPermutation(String str1, String str2) {
		if (str1.length() != str2.length()) {
			System.out.println(str1 + " is not a permutation of " + str2);
			return false;
		}
		char ch1[] = str1.toCharArray();
		char ch2[] = str2.toCharArray();

		Arrays.sort(ch1);
		Arrays.sort(ch2);

		for (int index = 0; index < ch1.length; index++) {
			if (ch1[index] != ch2[index]) {
				System.out.println(str1 + " is not a permutation of " + str2);
				return false;
			}
		}

		System.out.println(str1 + " is a permutation of " + str2);
		return true;
	}

	public static void main(String[] args) {
		checkPermutation("rotor", "wathy");
	}
}
