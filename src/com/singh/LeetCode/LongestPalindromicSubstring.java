package src.com.singh.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubstring {

    /*
        Given a string s, return the longest palindromic substring in s.

        Ex 1. s = "babad" -> "bab" or "aba"
        Ex 2. s = "cbbd" -> "bb"
        Ex 3. s = "xsaavbbd" -> "aa" or "bb"
        Ex 4. s = "xsaasxbbd" -> "xsaasx"

        Constraints: * s.length <= 1000
                     * s consists of only digits and English letters

        Algo:
     */

    public static String longestPalindromeDP(String s) {
        /*
            Time: O(n^2)
            Space: O(n^2)
         */

        if (s == null || "".equals(s)) {
            return s;
        }

        int len = s.length();

        String ans = "";
        int max = 0;

        boolean[][] dp = new boolean[len][len];

        for (int j = 0; j < len; j++) {

            for (int i = 0; i <= j; i++) {

                boolean judge = s.charAt(i) == s.charAt(j);

                dp[i][j] = j - i > 2 ? dp[i + 1][j - 1] && judge : judge;

                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    public static String longestPalindrome(String s) {
        /*
            Time: O(n^2)
            Space: O(1)
         */

        if (s == null || s.length() < 1)
            return "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeDP("babad"));
        System.out.println(longestPalindromeDP("cbbd"));
        System.out.println(longestPalindromeDP("xsaavbbd"));
        System.out.println(longestPalindromeDP("xsaasxbbd"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("xsaavbbd"));
        System.out.println(longestPalindrome("xsaasxbbd"));
    }
}
