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
    public String longestPalindromicSubstring(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
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

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        System.out.println(l.longestPalindromicSubstring("babad"));
        System.out.println(l.longestPalindromicSubstring("cbbd"));
    }
}
