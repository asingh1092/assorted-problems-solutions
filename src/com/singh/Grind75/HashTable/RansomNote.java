package src.com.singh.Grind75.HashTable;

import java.util.Map;
import java.util.TreeMap;

public class RansomNote {

    /*
           Given a String magazine, construct a String, ransomNote, using all the letters from the magazine
           Each later in magazine can only be used once in ransomNote

           N = number of characters in magazine
           M = number of chracters in ransomeNote
           Time: O(N) + O(M)
           Space: O(26) : O(1)
           Map<Character, Integer> map =
     */

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new TreeMap<>();
        for (char c : magazine.toCharArray()) {
            if (map.containsKey(c)) {
                map.replace(c, map.get(c) + 1);
            } else {
                map.putIfAbsent(c, 1);
            }
        }

        for (char c : ransomNote.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                map.replace(c, map.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean canConstructNeat(String ransomNote, String magazine) {
        int[] alphabets_counter = new int[26];

        for (char c : magazine.toCharArray())
            alphabets_counter[c-'a']++;

        for (char c : ransomNote.toCharArray()){
            if (alphabets_counter[c-'a'] == 0) return false;
            alphabets_counter[c-'a']--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "a"));
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "aab"));
    }
}
