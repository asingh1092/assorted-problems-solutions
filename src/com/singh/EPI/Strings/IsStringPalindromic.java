package com.singh.EPI.Strings;

public class IsStringPalindromic {
	
	//Time: O(n)
	//Space: O(1)
	public static boolean isPalindrome(String str) {
		for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[]) {
		System.out.println(isPalindrome("taco cat"));
	}

}
