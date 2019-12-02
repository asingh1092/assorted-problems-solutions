package test;

import java.util.Arrays;

public class Problem3 {

	/*
	 * Palindrome Permutation: Given a string, write a function to check if it is a
	 * permutation of a palindrome. A palindrome is a word or phrase that is the
	 * same forwards and backwards. A permutation is a rearrangement of letters. The
	 * palindrome does not need to be limited to just dictionary words.
	 * 
	 * EXAMPLE Input: Tact Coa Output: True (permutations: "taco cat", "atco eta",
	 * etc.) Hints: #106, #121, #134, #136
	 */

	public boolean isPalindromePermutation(String str) {
		int NO_OF_CHAR = 256;
		int count[] = new int[NO_OF_CHAR];
		Arrays.fill(count, 0);

		for (int i = 0; i < str.length(); i++) {
			count[(int) (str.charAt(i))]++;
		}

		int odd = 0;
		for (int i = 0; i < NO_OF_CHAR; i++) {
			if ((count[i] & 1) == 1) {
				i++;
			}
			if (odd > 1) {
				return false;
			}
		}
		return true;
	}
}
