package src.com.singh.Grind75.Array;

import java.util.Arrays;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        // Arrays.sort(nums);
        int idx = Arrays.binarySearch(nums, target);
        return nums[idx] == target ? idx : -1;
    }

    public static int searchActual(int[] nums, int target) {
        int pivot;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) {
                return pivot;
            }
            if (nums[pivot] < target) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
    }
}
