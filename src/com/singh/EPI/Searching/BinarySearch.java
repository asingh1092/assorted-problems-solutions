package com.singh.EPI.Searching;

import java.util.List;

public class BinarySearch {
	
	public static int binarySearch(int target, List<Integer> A) {
		int low = 0;
		int high = A.size() - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			// if mid index returns int less than target
			// change low index 
			if (A.get(mid) < target) {
				low = mid + 1;
			// if mid index returns target, then return target
			} else if (A.get(mid) == target) {
				return mid;
			// if mid index returns int greater than target
			// change high index 
			} else {
				high = mid - 1;
			}
		}
		// Did not find target
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
