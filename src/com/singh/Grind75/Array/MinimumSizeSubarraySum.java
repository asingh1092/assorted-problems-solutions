package src.com.singh.Grind75.Array;

public class MinimumSizeSubarraySum {

    /*
        2,3,1,2,4, 3
       b  ^
       e        ^
       min = 4
        2,5,6,8,12,15

     */

    public static int minSubarrayWRONG(int target, int[] nums) {
        int value = 0;
        int begin = 0;
        int end = 0;
        int size = nums.length;
        int min = 0;
        while (end < size) {
            for (int i = begin; i <= end; i++) {
                // go over window and see if we add up to target

                // use prefix sum here
                value += nums[i];
            }
            if (value >= target) {
                // handle initial min
                if (min == 0) min = end - begin + 1;
                    // otherwise compare to prev min
                else min = Math.min(min, end - begin + 1);
                // reset value

                // move up beginning of window and set end to begin;
                begin++;
                end = begin;
            } else {
                end++;
            }
            // reset value;
            value = 0;
        }
        return min;
    }

    public static int minSubarray(int target, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int begin = 0, end = 0, value = 0, min = Integer.MAX_VALUE;

        while (end < nums.length) {
            value += nums[end]; // prefix sum
            end++;

            while (value >= target) {
                min = Math.min(min, end - begin);
                value -= nums[begin]; // prefix sum
                begin++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        System.out.println(minSubarray(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubarray(4, new int[]{1, 4, 4}));
        System.out.println(minSubarray(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
    }
}
