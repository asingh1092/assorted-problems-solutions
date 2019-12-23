package com.singh.EPI.Strings;

public class StringIntegerInterconversion {

	public static int stringToIntegerConversion(String str) {
		return (str.charAt(0) == '-' ? -1 : 1) * 
				str.substring(str.charAt(0) == '-' ? 1 : 0)
				.chars()
				.reduce(0,
				(runningSum, c) -> runningSum * 10 + c - '0');
	}

	public static String integerToStringConversion(int n) {
		boolean isNegative = false;
		if (n < 0) {
			isNegative = true;
		}
		StringBuilder sb = new StringBuilder();
		do {
			sb.append((char) ('0' + Math.abs(n % 10)));
			n /= 10;
		} while (n != 0);
		return sb.append(isNegative ? "-" : "").reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
