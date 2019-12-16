package com.singh.CrTCI.test;

public class CodilityProblem {
	
	static int[] Solution(int x) {
		int MAX_SIZE = x*x;
		int[] multTable = new int[MAX_SIZE];
		
		int counter = 1;
		int other = 1;
		for (int i = 0; i < MAX_SIZE; i++) {
			multTable[i] = counter*other;
			counter++;
			if (counter > Math.abs(x)) {
				counter = 1;
				other++;
			}
		}
		return multTable;
	}
	
	public static void main(String args[]) {
		int[] array = Solution(-3);
		for (int n: array) {
			System.out.print(n);
		}
	}
}
