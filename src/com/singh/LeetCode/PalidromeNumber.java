package src.com.singh.LeetCode;

public class PalidromeNumber {
    public static boolean isNumberPalindrome(int input) {
        // negative base case
        if (input < 0) {
            return  false;
        }
        String inputAsString = String.valueOf(input);
        int left = 0;
        int right = inputAsString.length() - 1;
        while (left < right) {
            if (inputAsString.charAt(left) == inputAsString.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNumberPalindrome(121));
        System.out.println(isNumberPalindrome(-121));
        System.out.println(isNumberPalindrome(10));
    }
}
