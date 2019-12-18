package com.singh.EPI.Strings;

public class LookAndSay {

	public static String lookAndSay(int n) {
		String str = "1";
		for (int i = 1; i < n; i++) {
			str = nextNumLookAndSay(str);
		}
		return str;
	}

	private static String nextNumLookAndSay(String str) {
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
		for (int i = 0; i < 20; i++) {
			System.out.println(lookAndSay(i));
		}
	}

}
