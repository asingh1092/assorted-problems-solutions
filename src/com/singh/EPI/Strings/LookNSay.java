package com.singh.EPI.Strings;

import java.util.Random;

public class LookNSay {
	
	public static String lookNSay(int n) {
		String str = "1";
		for (int i = 1; i <= n; i++) {
			str = nextNumber(str);
		}
		return str;
	}

	private static String nextNumber(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			int count = 1;
			while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
				i++;
				count++;
			}
			sb.append(count).append(str.charAt(i));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Random rand = new Random();
		int num = rand.nextInt(50);
		System.out.println(num);
		System.out.println(lookNSay(num));
	}

}
