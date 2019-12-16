package com.singh.CrTCI.Arrays;

import java.io.*;
import java.util.*;

public class Problem5_oneAway {

	public static void main(String[] args) {
		boolean result1 = oneAway("pale", "ple");
		System.out.println(result1);
		boolean result2 = oneAway("pales", "pale");
		System.out.println(result2);
		boolean result3 = oneAway("pale", "bake");
		System.out.println(result3);
		boolean result4 = oneAway("pale", "bale");
		System.out.print(result4);
	}

	// insert, remove. replace

	static boolean oneAway(String str1, String str2) {
		char[] strToChar1 = str1.toCharArray();
		char[] strToChar2 = str2.toCharArray();

		Arrays.sort(strToChar1);
		Arrays.sort(strToChar2);

		// replace
		if (strToChar1.length == strToChar2.length) {
			for (int i = 0; i < strToChar1.length; i++) {
				int count = 0;
				for (int j = 0; j < strToChar2.length; j++) {
					if (strToChar1[i] == strToChar2[j]) {
						i++;
						j++;
					}
					if (strToChar1[i] != strToChar2[j]) {
						count++;
						i++;
						j++;
						if (count > 1) {
							return false;
						}
					}
				}
			}
		}
		if (strToChar1.length < strToChar2.length) {
			for (int i = 0; i < strToChar1.length; i++) {
				int count = 0;
				for (int j = 0; j < strToChar2.length; j++) {
					if (i == strToChar1.length) {
						break;
					}
					if (strToChar1[i] != strToChar2[j]) {
						count++;
						if (count > 1) {
							return false;
						} else {
							i++;
						}

					}
				}

			}
		}
		if (strToChar1.length > strToChar2.length) {
			for (int i = 0; i < strToChar2.length; i++) {
				int count = 0;
				for (int j = 0; j < strToChar1.length; j++) {
					if (i == strToChar2.length) {
						break;
					}
					if (strToChar2[i] != strToChar1[j]) {
						count++;
						if (count > 1) {
							return false;
						}
					} else {
						i++;
					}
				}

			}
		}
		return true;
	}
}
