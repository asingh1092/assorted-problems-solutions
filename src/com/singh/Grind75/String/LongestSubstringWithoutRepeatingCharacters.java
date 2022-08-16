package src.com.singh.Grind75.String;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    // Sliding window technique

    public static int longestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int begin = 0;
        int end = 0;
        int size = s.length();
        while (end < size) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(end));
                begin++;
            } else {
                set.add(s.charAt(end));
                end++;
                max = Math.max(max, set.size());
            }
        }
        return max;
    }
}
