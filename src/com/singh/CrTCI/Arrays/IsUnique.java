package com.singh.CrTCI.Arrays;

import java.util.HashSet;
import java.util.Set;

public class IsUnique {
	
	public static boolean isUnique(String word) {
		char[] chArray = new char[word.length()];
		chArray = word.toCharArray();
		Set<Character> hSet = new HashSet<>();
		for(char c : chArray) {
			if (hSet.contains(c)) {
				return false;
			} else {
				hSet.add(c);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String test1 = "test";
		System.out.println(isUnique(test1));
		
		String test2 = "";
		System.out.println(isUnique(test2));
		
		String test3 = "this is gonna be a long one";
		System.out.println(isUnique(test3));
	}

}
