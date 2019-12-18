package com.singh.EPI.Arrays;

import java.util.ArrayList;
import java.util.List;

public class DutchNationalFlag {
	
	public enum Color { RED, WHITE, BLUE }
	public static void dutchFlagPartition(List<Color> A, int pivotIndex) {
		Color pivot = A.get(pivotIndex);
		List<Color> lessThanPivotList = new ArrayList<>();
		List<Color> greaterThanPivotList = new ArrayList<>();
		
		// A.get(index).ordinal() -> ordinal() method returns the order of an enum instance
		for (int i = 0; i < A.size() - 1; i++) {
			if (A.get(i).ordinal() < pivot.ordinal()) {
				lessThanPivotList.add(A.get(i));
			} else {
				greaterThanPivotList.add(A.get(i));
			}
		}
		int i = 0;
		int j = 0;
		for (int indexOfA = 0; indexOfA < A.size() - 1; indexOfA++) {
			while (!lessThanPivotList.isEmpty()) {
				A.set(indexOfA, lessThanPivotList.get(i));
				i++;
				indexOfA++;
			}
			
			A.set(indexOfA, pivot);
			indexOfA++;
			
			while (!greaterThanPivotList.isEmpty()) {
				A.set(indexOfA, greaterThanPivotList.get(j));
				j++;
				indexOfA++;
			}
		}
	}
	

}
