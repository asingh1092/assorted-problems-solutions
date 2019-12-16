package com.singh.CrTCI.Arrays;

import java.util.HashSet;

public class Problem1_isUnique {
	/* implement an algorithm to determine if a string has all unique characters */
	
	static boolean isUnique(String word) {
		HashSet<Character> setOfWords = new HashSet<Character>();
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!setOfWords.add(c)) {
				System.out.println(word + " does not have unqiue characters");
				return false;
			}
		}
		System.out.println(word + " has unique characters");
		return true;
	}
	
	public static void main(String[] args) {
		isUnique("loft");
	}
}
