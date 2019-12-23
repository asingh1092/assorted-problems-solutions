package com.singh.EPI.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class SortedArrayRemoveDupsVariants {
	
	// Time: O(n)
	// Space > O(1);
	public static int deleteDups(List<Integer> A) {
		System.out.println("Input Array: " + A);
		Set<Integer> hSet = new HashSet<>();
		int count = 0;  
		for (int i = 0; i < A.size(); i++) {
			if (!hSet.contains(A.get(i))) {
				count++;
				hSet.add(A.get(i));
			} else {
				A.remove(i);
				i--;
			}
		}
		System.out.println("Output Array: " + A);
		return count;
	}
	
	public static int deleteDupsStaticArrays(int[] A) {
		Arrays.sort(A);
		System.out.println("Input Array: " + Arrays.toString(A));
		if (Arrays.asList(A).isEmpty()) {
			return 0;
		}
		int count = 1;
		for (int i = 1; i < A.length; i++) {
			if (!(A[count - 1] == A[i])) {
				A[count] = A[i];
				count++;
			}
		}
		
		return count;
	}
	
	

	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<Integer>();
		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			intList.add(rand.nextInt(10));
		}
		
		int[] intArray = new int[15]; 
		for (int i = 0; i < 15; i++) {
			intArray[i] = rand.nextInt(5);
		}
		System.out.println(deleteDups(intList));
		System.out.println(deleteDupsStaticArrays(intArray));
	}

}
