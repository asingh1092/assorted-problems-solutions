package src.com.singh.Grind75.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {

    /*
     *  Given an integer array nums, return true if any value appears at least twice in the array
     *  and return false if every element is distinct
     *
     *  Use a hashset to keep track of elements we've already seen
     *  Time: O(n)
     *  Space: O(n)
     *
     *  Sort the array - if current element is the same for more than one index, then we have duplicates
     * Time: O(n log( n))
     *
     */

    public static boolean containsDuplicates(int[] nums) {
        Set<Integer> hSet = new HashSet<>();
        for (int num : nums) {
            if (hSet.contains(num)) {
                return true;
            } else {
                hSet.add(num);
            }
        }
        return false;
    }

    public static boolean containsDuplicatesNoSpace(int[] nums) {
        Arrays.sort(nums);
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (current == nums[i]) {
                return true;
            } else {
                current = nums[i];
            }
        }
        return false;
    }

    public static void main(String[] args) {
    }
}
