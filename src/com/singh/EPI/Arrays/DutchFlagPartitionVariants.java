package com.singh.EPI.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DutchFlagPartitionVariants {

	// Time: O(n)
	// Space: O(1)
	public static List<Boolean> booleanVariant(List<Boolean> A) {
		int equal = 0;
		int fwPointer = 0;
		int bwPointer = A.size() - 1;
		while (equal < bwPointer) {
			if (!A.get(fwPointer)) {
				fwPointer++;
				equal++;
			} else {
				Collections.swap(A, equal, bwPointer--);
			}
		}

		return A;
	}

	public static List<String> variant1(List<String> A, int pivotIndex) {
		String pivot = A.get(pivotIndex);
		int equal = 0;
		int fwPointer = 0;
		int bwPointer = A.size() - 1;
		while (equal < bwPointer) {
			if (A.get(fwPointer) == pivot) {
				equal++;
				fwPointer++;
			} else {
				Collections.swap(A, equal, bwPointer--);
			}
		}

		return A;
	}

	public enum Color {
		RED, WHITE, BLUE, GREEN
	}

	public static List<Color> variant2(List<Color> A) {
		int small = 0;
		int mid1 = 0;
		int mid2 = 0;
		int large = A.size() - 1;
		while (small < large) {
			if (A.get(small) == Color.RED) {
				small++;
				mid1++;
				mid2++;
			} else if (A.get(small) == Color.WHITE) {
				Collections.swap(A, small, mid1);
				mid1++;

			} else if (A.get(small) == Color.BLUE) {
				Collections.swap(A, small, mid2);
				mid2++;
			} else {
				Collections.swap(A, small, large);
				large--;
			}
		}
		return A;
	}

	public static void main(String[] args) {
		List<Boolean> BooleanA = new ArrayList<Boolean>();
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			BooleanA.add(rand.nextBoolean());
		}

		List<String> stringof3List = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int random = rand.nextInt(3);
			switch (random) {
			case 0:
				stringof3List.add("Red");
				break;
			case 1:
				stringof3List.add("White");
			case 2:
				stringof3List.add("Blue");
			}
		}

		List<Color> fourColorList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int random = rand.nextInt(4);
			switch (random) {
			case 0:
				fourColorList.add(Color.RED);
				break;
			case 1:
				fourColorList.add(Color.WHITE);
			case 2:
				fourColorList.add(Color.BLUE);
			case 3:
				fourColorList.add(Color.GREEN);
			}
		}

		System.out.println(booleanVariant(BooleanA));
		System.out.println(variant1(stringof3List, rand.nextInt(3)));
		System.out.println(variant2(fourColorList));

	}

}
