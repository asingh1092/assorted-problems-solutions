package Moderate;

import java.io.*;
import java.util.*;

public class Problem1_numberSwapper {
	
	static void numberSwapper(int[] n) {
		int numbersAdded = n[0] + n[1];
		int[] swapped = new int[n.length];
		swapped[0] = numbersAdded - n[0];
		swapped[1] = numbersAdded - n[1];
		for (int number : swapped) {
			System.out.print(number + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] numbList = {1, 2};
		numberSwapper(numbList);
	}

}
