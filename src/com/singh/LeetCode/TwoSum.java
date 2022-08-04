package src.com.singh.LeetCode;

import java.util.Arrays;

public class TwoSum {

    /*
        Given an array of integers nums and an integer target,
        return indices of the two numbers such that they add up to the target

        Assumptions
            * each input only has exactly one solution
            * you may not use the same element twice

        Constraints
            * 2 <= nums.length <= 104
            * -109 <= nums[i] <= 109
            * -109 <= target <= 109
            * Only one valid answer exists.
     */

    public static int[] twoSum(int[] nums, int target) {
        /*
            Time: O(n^2)
            Space: O(1);

         */

        int[] ret = new int[]{0, 0};
        int len = nums.length;

        if (len == 2) {
            ret = new int[]{0, 1};
            return ret;
        }

        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > 0; j--) {
                if (nums[i] + nums[j] == target) {
                    ret = new int[]{i, j};
                }
            }
        }
        return ret;
    }

    // Can we change the array and make the search faster?

    // Can we leverage some other data structure to make the search faster than O(n^2)

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }
}
