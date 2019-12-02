package Arrays;

import java.util.ArrayList;

public class Problem3_URLify2 {
	
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
		
		return chars.toString();
	}

	public static void main(String[] args) {
		char[] chars = "Mr John Smith       ".toCharArray();
		System.out.println(replaceSpaces(chars, 13));
	}
}

