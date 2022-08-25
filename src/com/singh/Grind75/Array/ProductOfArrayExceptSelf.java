package src.com.singh.Grind75.Array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    /*
        Return is an int[] answer such that answer[i] is equal to the product of all elements of nums except nums[i]

        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

        You must write an algorithm that runs in O(n) time and without using the division operation.
            nums: {1, 5, 3, 1, 2}
            answer: {30, 6, 10, 30, 15}
                prefix: {1, 5, 15, 15, 30}
                suffix: {30, 30, 6, 2, 2}
     */

    /*
       Time: O(n^2)
       Space O(n)

     */

    public static int[] productExceptSelfWrong(int[] nums) {
        int size = nums.length;
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            int product = 1;
            int forward = i - 1;
            int backward = i + 1;
            while (forward >= 0) {
                product *= nums[forward];
                forward--;
            }
            while (backward < size) {
                product *= nums[backward];
                backward++;
            }
            ret[i] = product;
        }
        return ret;
    }

    public static int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] ret = new int[size];

        return ret;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelfWrong(new int[]{-1,1,0,-3,3})));
    }
}
