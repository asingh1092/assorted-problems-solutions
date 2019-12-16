package com.singh.CrTCI.Arrays;

public class Problem4_PalindromePermutation {

	// Palidrone = same forward as backward
	// at max would have even amount of letters with 1 odd letter

	// boolean isPalidronePermutation(String phrase)
	// build table
	// check to see if there are even amount of letter & 1 odd
	
	public static void main(String args[]) {
		String phrase = "Tact Coa";
		Problem4_PalindromePermutation problem = new Problem4_PalindromePermutation();
		System.out.print(problem.isPalidronePermutation(phrase));
	}
	
	 boolean isPalidronePermutation(String phrase) {
		int[] table = buildCharFrequencyTable(phrase);
		return checkEvenAndOneOdd(table);
	}

	private boolean checkEvenAndOneOdd(int[] table) {
		boolean foundOdd = false;
		for (int count : table) {
			if (count % 2 == 1) {
				if (foundOdd) {
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
	}


	int[] buildCharFrequencyTable(String phrase) {
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			if (x != -1) {
				table[x]++;
			}
		}
		return table;
	}

	private int getCharNumber(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if (a <= val && val <= z) {
			return val - a;
		}
		return -1;
	}

}
