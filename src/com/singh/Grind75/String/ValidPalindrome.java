package src.com.singh.Grind75.String;

import java.util.Stack;

public class ValidPalindrome {

    // remove white space first

    /* Use a stack or reverse the string and compare to original

       O(2n) -> O(n) time
       O(n) space -> stack / reverse

        first check if length is even or odd
        if odd, then center character will appear twice
        else we'll have even amount of chacters
       Two pointers one on each end

       O(n) time
       O(1) space

     */

    public static boolean validPalindromeBigSpace(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
        }

        for (char c : s.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static boolean validPalindrome(String s) {
        boolean isEven = s.length() % 2 == 0;

        int beginIdx = 0;
        int endIdx = s.length() - 1;

        while (isEven ? beginIdx < endIdx : beginIdx <= endIdx) {
            if (s.charAt(beginIdx) != s.charAt(endIdx)) {
                return false;
            }
            beginIdx++;
            endIdx--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(validPalindrome(s));
        System.out.println(validPalindromeBigSpace(s));
        s = "aba";
        System.out.println(validPalindrome(s));
        System.out.println(validPalindromeBigSpace(s));
        s = "abbbbbbcbba";
        System.out.println(validPalindrome(s));
        System.out.println(validPalindromeBigSpace(s));
    }
}
