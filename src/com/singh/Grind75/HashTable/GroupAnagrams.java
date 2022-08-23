package src.com.singh.Grind75.HashTable;

import src.com.singh.Grind75.Array.SieveOfEratosthenes;

import java.util.*;

public class GroupAnagrams {

    private final SieveOfEratosthenes sieve = new SieveOfEratosthenes();

    /*
       Given an array of strings strs, group the anagrams together. You can return the answer in any order.

       An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
       typically using all the original letters exactly once.

        validAnagram() -> sort the chars in a string then check letters or

        * 1 <= strs.length <= 10^4
        * 0 <= strs[i].length <= 100
        * strs[i] consists of lowercase English letters

        helper function isAnagram(String str1, String str2) -> map each char to prime number and multiple each mapped number together;
        anagrams should have the same multiple

        prime -> 1, 2, 3, 5, 7, 11, 13, 17, 19,

        helper getPrime(int n) -> prime iff the number is divisble by itself  and 1  sqrt(n)
        isPrime -> N % N = 0 && N % 1 = O
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        List<Integer> primes = sieve.generatePrimesToEratosthenes(500);

        Map<Character, Integer> primeCharMap = new TreeMap<>();
        int alphabet = 0;
        for (char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
            primeCharMap.put(c, primes.get(alphabet));
            alphabet++;
        }
        Map<Integer, ArrayList<String>> map = new TreeMap<>();
        List<List<String>> ret = new ArrayList<>();

        for (String str : strs) {
            int value = 1;
            for (int i = 0; i < str.length(); i++) {
                for (char c : str.toCharArray()) {
                    value *= primeCharMap.get(c);
                }
            }
            if (map.containsKey(value)) {
                map.get(value).add(str);
            } else {
                ArrayList<String> listToPut = new ArrayList<>();
                listToPut.add(str);
                map.putIfAbsent(value, listToPut);
            }
        }
        for (Integer i : map.keySet()) {
            ret.add(map.get(i));
        }
        return ret;
    }

    public static void main(String[] args) {
        GroupAnagrams anagrams = new GroupAnagrams();
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(anagrams.groupAnagrams(strs));
    }
}
