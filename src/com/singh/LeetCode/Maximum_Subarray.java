package com.singh.LeetCode;

import java.util.Collections;

public class Maximum_Subarray {

	public static void main(String args[]) {
		int[] arry = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int result = maxSubArray(arry);
		System.out.println(result);
	}

	public static int maxSubArray(int[] nums) {
		int size = nums.length;
		int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

		for (int i = 0; i < size; i++) {
			max_ending_here = max_ending_here + nums[i];
			if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
			if (max_ending_here < 0)
				max_ending_here = 0;
		}
		return max_so_far;
	}

}
