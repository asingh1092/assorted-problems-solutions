package Arrays;

import java.util.ArrayList;

public class Problem3_URLify {
	
	public static String urlifytest(String sentence, int trueLength) {
		
		String url = "%20";
		char[] charSentence = sentence.trim().toCharArray();
		for (int i = 0; i < charSentence.length; i++) {
			if (charSentence[i] == ' ') {
				charSentence[i] = '%';
			}
		}
		String newSent = charSentence.toString();
		return newSent;
	}
		
	public static String replaceSpaces(char[] chars, int len) {
		if (chars == null) {
			return "";
		}
		int spaceCount = 0;
		int index = 0;
		// first loop, locate last position
		for (int i = 0; i < len; i++) {
			if (chars[i] == ' ') {
				spaceCount++;
			}
		}
		index = len + spaceCount * 2 - 1;
		// second loop, replace spaces from the end
		for (int i = len - 1; i >= 0; i--) {
			if (chars[i] == ' ') {
				chars[index] = '0';
				chars[index - 1] = '2';
				chars[index - 2] = '%';
				index -= 3;
			} else {
				chars[index] = chars[i];
				index--;
			}
		}
		return new String(chars).trim();
	}

	public static void main(String[] args) {
		char[] chars = "Mr John Smith       ".toCharArray();
		System.out.println(replaceSpaces(chars, 13));
	}
}

