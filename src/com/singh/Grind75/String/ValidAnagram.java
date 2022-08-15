package src.com.singh.Grind75.String;

import java.util.Arrays;

public class ValidAnagram {

    /*
        1. Sorting
        n = m
        Time: O(nlogn + mlogm) = O(nlogn)
        Space: O(n + m) = O(n)
     */

    public static boolean isValidAnagramSorting(String s, String t) {
        // base
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        // sort both strings
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        for (int i = 0; i < s.length(); i++) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }
        return true;
    }

    /*
        Frequency of counting characters - if ascii
        n = m
        Time: O(n + m) = O(2n) = O(n)
        Space: O(26) = O(1)
     */

    public static boolean isValidAnagramAscii(String s, String t) {
        // base
        if (s.length() != t.length()) {
            return false;
        }
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }

    public static boolean isValidAnagramUnicode(String s, String t) {
        // base
        return true;
    }
}
