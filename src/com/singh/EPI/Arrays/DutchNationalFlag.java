package com.singh.EPI.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DutchNationalFlag {
	
	public enum Color { RED, WHITE, BLUE }
	public static List<Color> dutchFlagPartition1(List<Color> A, int pivotIndex) {
		Color pivot = A.get(pivotIndex);
		List<Color> lessThanPivotList = new ArrayList<>();
		List<Color> equalToPivotList = new ArrayList<>();
		List<Color> greaterThanPivotList = new ArrayList<>();
		
		// A.get(index).ordinal() -> ordinal() method returns the order of an enum instance
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i).ordinal() < pivot.ordinal()) {
				lessThanPivotList.add(A.get(i));
			} 
			if (A.get(i).ordinal() > pivot.ordinal()) {
				greaterThanPivotList.add(A.get(i));
			}
			if (A.get(i).ordinal() == pivot.ordinal()) {
				equalToPivotList.add(A.get(i));
			}
		}
		for (int indexOfA = 0; indexOfA < A.size() - 1; indexOfA++) {
			while (!lessThanPivotList.isEmpty()) {
				A.set(indexOfA, lessThanPivotList.get(0));
				lessThanPivotList.remove(0);
				indexOfA++;
			}
			
			while (!equalToPivotList.isEmpty()) {
				A.set(indexOfA, equalToPivotList.get(0));
				equalToPivotList.remove(0);
				indexOfA++;
			}
			
			while (!greaterThanPivotList.isEmpty()) {
				A.set(indexOfA, greaterThanPivotList.get(0));
				greaterThanPivotList.remove(0);
				indexOfA++;
			}
		}
		
		return A;
	}
	
	public static List<Color> dutchFlagPartition2(List<Color> A, int pivotIndex) {
		Color pivot = A.get(pivotIndex);
		for (int i = 0; i < A.size(); i++) {
			for (int j = i + 1; j < A.size(); j++) {
				if (A.get(j).ordinal() < pivot.ordinal()) {
					Collections.swap(A, i, j);
					break;
				}
			}
		}
		
		for (int i = A.size() - 1; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (A.get(j).ordinal() > pivot.ordinal()) {
					Collections.swap(A, i, j);
					break;
				}
			}
		}
		return A;
	}
	
	public static void main(String args[]) {
		List<Color> list = new ArrayList<>();
		list.add(Color.RED);
		list.add(Color.BLUE);
		list.add(Color.RED);
		list.add(Color.WHITE);
		
		// Time: O(n) because the list of inputs was iterated over only once
		// Space: O(n) because of extra lists 
		System.out.println(dutchFlagPartition1(list, 1));
		System.out.println(dutchFlagPartition1(list, 2));
		System.out.println(dutchFlagPartition1(list, 3));
		System.out.println(dutchFlagPartition2(list, 1));
		System.out.println(dutchFlagPartition2(list, 2));
		System.out.println(dutchFlagPartition2(list, 3));

	}

}
