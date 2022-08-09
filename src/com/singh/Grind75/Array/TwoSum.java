package src.com.singh.Grind75.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    /**
     * Leverage a hashmap of O(n) space to reduce time complexity down to O(2n) -> O(n)
     * where n is the number of nums.
     *
     * @param nums   list of numbers
     * @param target target to add to
     * @return int array of the indices of the two numbers that add up to the target
     */
    public static int[] twoSumTwoPassHashTable(int[] nums, int target) {
        Map<Integer, Integer> hMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hMap.containsKey(complement) && hMap.get(complement) != i) {
                return new int[]{i, hMap.get(complement)};
            }
        }
        return null;
    }

    public static int[] twoSumOnePassHashTable(int[] nums, int target) {
        Map<Integer, Integer> hMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hMap.containsKey(complement)) {
                return new int[]{i, hMap.get(complement)};
            }
            hMap.put(nums[i], i);
        }

        return null;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));

        System.out.println(Arrays.toString(twoSumTwoPassHashTable(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSumTwoPassHashTable(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSumTwoPassHashTable(new int[]{3, 3}, 6)));

        System.out.println(Arrays.toString(twoSumOnePassHashTable(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSumOnePassHashTable(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSumOnePassHashTable(new int[]{3, 3}, 6)));
    }
}
