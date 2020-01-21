package com.singh.LeetCode;

public class CoinProblem {

	public static void main(String args[]) {
		optimize(2);
	}

	static class Change {
		long coin2;
		long bill5;
		long bill10;

		Change(long coin2, long bill5, long bill10) {
			System.out.println("Number of bill10s: " + bill10);
			System.out.println("Number of bill5: " + bill5);
			System.out.println("Number of coin2: " + coin2);
		}
	}

	public static Change optimize(long s) {
		long changeOf2 = 0;
		long changeOf5 = 0;
		long changeOf10 = 0;

		if ((s % 10) > 0) {
			changeOf10 = (long) Math.floor(s / 10);
			s = s - changeOf10 * 10;
			if ((s % 5) > 0) {
				changeOf5 = (long) Math.floor(s);
				s = s - changeOf5 * 5;
				if ((s % 2) == 0) {
					changeOf2 = s / 2;
					return new Change(changeOf2, changeOf5, changeOf10);
				}
				return new Change(changeOf2, changeOf5, changeOf10);
			} else {
				if ((s % 2) == 0) {
					changeOf2 = s / 2;
					return new Change(changeOf2, changeOf5, changeOf10);
				}
				return new Change(changeOf2, changeOf5, changeOf10);
			}
		}

		if ((s % 5) > 2) {
			changeOf5 = (long) Math.floor(s / 5);
			s = s - changeOf5 * 5;
			if ((s % 2) == 0) {
				changeOf2 = s / 2;
				return new Change(changeOf2, changeOf5, changeOf10);
			}
			return new Change(changeOf2, changeOf5, changeOf10);
		}

		if ((s % 2) == 0) {
			changeOf2 = s / 2;
			return new Change(changeOf2, changeOf5, changeOf10);
		}

		return null;
	}
}
