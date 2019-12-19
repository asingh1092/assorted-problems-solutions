package com.singh.EPI.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DutchNationalFlag {

	public enum Color {
		RED, WHITE, BLUE
	}

	// Time: 0(n) + O(n) = O(2n) ~ O(n)
	// Space: O(n)
	public static List<Color> dutchFlagPartition1(List<Color> A, int pivotIndex) {
		Color pivot = A.get(pivotIndex);
		List<Color> lessThanPivotList = new ArrayList<>();
		List<Color> equalToPivotList = new ArrayList<>();
		List<Color> greaterThanPivotList = new ArrayList<>();

		// A.get(index).ordinal() -> ordinal() method returns the order of an enum
		// instance
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

	// Time: O(n^2) + O(n^2) = O(2n^2) ~ O(n^2)
	// Space: O(1)
	// Problem: Only give back 2 different stripes out of 3
	public static List<Color> dutchFlagPartition2(List<Color> A, int pivotIndex) {
		Color pivot = A.get(pivotIndex);
		// 1st pass sorting less than pivot
		for (int i = 0; i < A.size(); i++) {
			for (int j = i + 1; j < A.size(); j++) {
				if (A.get(j).ordinal() < pivot.ordinal()) {
					Collections.swap(A, i, j);
					break;
				}
			}
		}

		// 2nd pass sorting greater than pivot
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

	// Time: O(n) + O(n) = 2*O(n) ~ O(n)
	// Space: O(1)
	public static String dutchFlagPartitionStaticArray(Color[] arr, int pivotIndex) {
		Color pivot = arr[pivotIndex];
		int fwdPointer = 0;
		int bwPointer = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].ordinal() < pivot.ordinal()) {
				swap(arr, fwdPointer++, i);
			}
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i].ordinal() > pivot.ordinal()) {
				swap(arr, bwPointer--, i);
			}
		}

		return Arrays.toString(arr);
	}

	private static Color[] swap(Color[] arr, int i, int j) {
		Color temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}

	// Time: O(n) + O(n) = 2*O(n) ~ O(n)
	// Space: O(1)
	public static List<Color> dutchFlagPartitionArrayList(List<Color> A, int pivotIndex) {
		Color pivot = A.get(pivotIndex);
		int fwPointer = 0;
		int bwPointer = A.size() - 1;
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i).ordinal() < pivot.ordinal()) {
				Collections.swap(A, fwPointer++, i);
			}
		}

		for (int i = A.size() - 1; i >= 0; i--) {
			if (A.get(i).ordinal() > pivot.ordinal()) {
				Collections.swap(A, bwPointer--, i);
			}
		}
		return A;
	}
	
	public static List<Color> dutchFlagPartition3(List<Color> A, int pivotIndex) {
		Color pivot = A.get(pivotIndex);
		int equal = 0;
		int fwPointer = 0;
		int bwPointer = A.size();
		while (equal < bwPointer) {
			if (A.get(equal).ordinal() < pivot.ordinal()) {
				Collections.swap(A, fwPointer++, equal++);
			}
			else if (A.get(equal).ordinal() > pivot.ordinal()) {
				Collections.swap(A, equal, --bwPointer);
			} else {
				++equal;
			}
		}
		
		return A;
	}

	public static void main(String args[]) {
		List<Color> list = new ArrayList<>();
		list.add(Color.WHITE);
		list.add(Color.RED);
		list.add(Color.BLUE);
		list.add(Color.WHITE);
		list.add(Color.RED);
		list.add(Color.WHITE);
		list.add(Color.BLUE);

		Color[] arr = { Color.WHITE, Color.RED, Color.BLUE, Color.WHITE, Color.RED, Color.WHITE, Color.BLUE };

		// Time: O(n) because the list of inputs was iterated over only once
		// Space: O(n) because of extra lists
		System.out.println(dutchFlagPartition1(list, 0));
		System.out.println(dutchFlagPartition1(list, 1));
		System.out.println(dutchFlagPartition1(list, 2));
		System.out.println(dutchFlagPartition2(list, 0));
		System.out.println(dutchFlagPartition2(list, 1));
		System.out.println(dutchFlagPartition2(list, 2));
		System.out.println(dutchFlagPartitionArrayList(list, 0));
		System.out.println(dutchFlagPartitionArrayList(list, 1));
		System.out.println(dutchFlagPartitionArrayList(list, 2));
		System.out.println(dutchFlagPartitionStaticArray(arr, 0));
		System.out.println(dutchFlagPartitionStaticArray(arr, 1));
		System.out.println(dutchFlagPartitionStaticArray(arr, 2));
		System.out.println(dutchFlagPartition3(list, 0));
		System.out.println(dutchFlagPartition3(list, 1));
		System.out.println(dutchFlagPartition3(list, 2));
	}

}
