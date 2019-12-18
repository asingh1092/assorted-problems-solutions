package com.singh.CrTCI.Arrays;

public class URLify {
	
	// replace " " with "%20" 
	
	public static String urlify(String word, int trueSize) {
		/*char[] cWord = word.trim().toCharArray();
		for (int i = trueSize - 1; i > 0; i--) {
			if (cWord[i] == ' ') {
				cWord[i] = '0';
				cWord[i-1] = '2';
				cWord[i-2] = '%';
			}
		}
		return cWord.toString(); */
		
		char[] cWord = word.toCharArray();
		int numOfSpaces = countOfChar(cWord, 0, trueSize, ' ' );
		int newIndex = trueSize - 1 + numOfSpaces * 2;
		
		/* If there is excess space, add a null character.
		 * This indicates that the spaces after that point have not been 
		 * replaced with %20. 
		 */
		if (newIndex + 1 < cWord.length) {
			cWord[newIndex + 1] = '\0';
		}
		
		for (int oldIndex = trueSize - 1; oldIndex >= 0; oldIndex -= 1) {
			if (cWord[oldIndex] == ' ' ) {
				cWord[newIndex] = '0';
				cWord[newIndex-1] = '2';
				cWord[newIndex-2] = '%';
				newIndex -= 3;
			} else {
				cWord[newIndex] = cWord[oldIndex];
				newIndex -= 1;
			}
		}
		
		return new String(cWord).trim();
	}

	private static int countOfChar(char[] cWord, int start, int end, char target) {
		int count = 0;
		for (int i = start; i < end; i++) {
			if (cWord[i] == target) {
				count++;
			}
		}
		return count;
	}
	
	public static String replaceChars(String sentence, int trueSize) {
		StringBuilder sb = new StringBuilder(sentence);
		for (int i = 0; i < trueSize; i++) {
			if (sb.charAt(i) == ' ' ) {
				sb.replace(i, i + 1, "%20");
			}
		}
		return new String(sb).trim();
	}

	public static void main(String[] args) {
		String result  = urlify("Mr John Smith       ", 13);
		String result2 = replaceChars("Mr John Smith       ", 13);
		System.out.println(result);
		System.out.println(result2);
	}

}
