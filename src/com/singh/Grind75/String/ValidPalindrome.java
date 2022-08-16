package src.com.singh.Grind75.String;

import java.util.Stack;

public class ValidPalindrome {

    // Don't assume its just ascii characters. Don't forget about case either.

    // remove white space && make upper case characters into lower case

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
        int beginIdx = 0;
        int endIdx = s.length() - 1;
        while (beginIdx <= endIdx) {
            if (!Character.isLetterOrDigit(s.charAt(beginIdx))) beginIdx++;
            else if (!Character.isLetterOrDigit(s.charAt(endIdx))) endIdx--;
            else if (Character.toLowerCase(s.charAt(beginIdx++)) != Character.toLowerCase(s.charAt(endIdx--)))
                return false;
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
