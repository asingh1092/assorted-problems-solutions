package src.com.singh.Grind75.Array;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    /*
        Test 1: abcabcbb
                ^
                Set:
     */

    public static int longestSubstringWithoutRepeatingCharactersWRONG(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (s.equals(" ")) {
            return 1;
        }
        Set<Character> hSet = new HashSet<>();
        int size = s.length();
        int counter = 0; // count substring -> reset if necessary
        int begin = 0; // beginning of window
        int end = 0; // end of window
        int d = 0; // thing to check counter against; update if counter is larger
        char[] charArray = s.toCharArray();
        while (end < size) {
            if (hSet.contains(s.charAt(end))) {
                // reset counter because we found a repeating character
                if (counter > d) {
                    d = counter;
                }
                counter = 0;
                begin++;
                end = begin;
                hSet.clear();
            } else {
                hSet.add(s.charAt(end));
                end++;
                counter++;
            }
        }
        return d;
    }

    public static int longestSubstringWithoutRepeatingCharacters(String s) {
        Set<Character> hSet = new HashSet<>();
        int size = s.length();
        int begin = 0; // beginning of window
        int end = 0; // end of window
        int max = 0; // thing to check
        while (end < size) {
            if (hSet.contains(s.charAt(end))) {
                hSet.remove(s.charAt(begin));
                begin++;
            } else {
                hSet.add(s.charAt(end));
                end++;
                max = Math.max(max, hSet.size());
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutRepeatingCharacters("abcabcbb"));
        System.out.println(longestSubstringWithoutRepeatingCharacters("bbbbb"));
        System.out.println(longestSubstringWithoutRepeatingCharacters("pwwkew"));
        System.out.println(longestSubstringWithoutRepeatingCharacters("c"));
    }

}
