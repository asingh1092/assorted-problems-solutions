package src.com.singh.Grind75.Array;

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

    public static int[] productExceptSelfWrong(int[] nums) {
        int size = nums.length;
        int total = 1;
        int[] answer = new int[size];
        for (int num : nums) {
            total *= num;
        }
        for (int i = 0; i < size; i++) {
            answer[i] = (nums[i] != 0) ? total / nums[i] : total;
        }
        return answer;
    }
}
