package test;

import java.util.Arrays;

public class Problem1 {

	public boolean isUnique(String str) {
		char[] chArray = str.toCharArray();
		Arrays.sort(chArray);
		for (int i = 0; i < chArray.length - 1; i++) {
			if (chArray[i] != chArray[i + 1]) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}
