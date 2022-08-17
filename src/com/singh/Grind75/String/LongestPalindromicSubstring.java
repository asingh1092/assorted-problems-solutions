package src.com.singh.Grind75.String;

public class LongestPalindromicSubstring {

    // Ask about ascii characters vs unicode + if there is any white space and case type
    // DYNAMIC PROGRAMMING

    /*
        Ex 1: babad -> bab or aba
        Ex 2: cbbd -> bb
        s is only digits and English letters



     */

    // top-bottom attempt
    public static String longestPalindrome(String s) {
        String max = "";
        int begin = 0;
        int end = 0;
        int size = s.length();
        while (end < size) {
            if (s.charAt(begin) == s.charAt(end)) {
                // check if palindrome
                boolean isPalindrome = true;
                for (int i = begin, j = end; i < j; i++, j--) {
                    if (s.charAt(i) != s.charAt(j)) {
                        isPalindrome = false;
                        break;
                    }
                }
                // if is Palindrome, check around it
                if (isPalindrome) {
                    String sub = s.substring(begin, end + 1);
                    if (sub.length() > max.length()) {
                        max = sub;
                    }
                    if (begin == 0) begin++;
                    else begin--;
                } else {
                    begin++;
                }
            } else {
                begin++;
            }
            end++;
        }
        return max;
    }

    // bottom-top method
    // O(n^2) time
    // O(1) space
    public static String longestPalindromicSubstring(String s) {
        int maxLen = 0, lo = 0;
        int size = s.length();

        for (int i = 0; i < size; i++) {
            // Odd: check around char at i;
            int L = i, R = i;
            while (L > 0 && R < size && s.charAt(L) == s.charAt(R)) {
                L--;
                R++;
            }
            if (maxLen < R - L - 1) {
                lo = L + 1;
                maxLen = R - L - 1;
            }
            // Even: check around i and i + 1
            L = i;
            R = i + 1;
            while (L > 0 && R < size && s.charAt(L) == s.charAt(R)) {
                L--;
                R++;
            }
            if (maxLen < R - L - 1) {
                lo = L + 1;
                maxLen = R - L - 1;
            }
        }
        return s.substring(lo, lo + maxLen);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstring("babad"));
        System.out.println(longestPalindromicSubstring("cbbd"));
    }
}
