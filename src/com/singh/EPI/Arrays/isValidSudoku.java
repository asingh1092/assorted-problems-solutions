package com.singh.EPI.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class isValidSudoku {

	private boolean hasDupValues(List<List<Integer>> board, int rowStart, int rowEnd, int colStart, int colEnd) {
		List<Boolean> isPresent = new ArrayList<>(Collections.nCopies(board.size() + 1, false));
		for (int i = rowStart; i < rowEnd; i++) {
			for (int j = colStart; j < colEnd; j++) {
				if (board.get(i).get(j) != 0 && isPresent.get(board.get(i).get(j))) {
					return true;
				}
				isPresent.set(board.get(i).get(j), true);
			}
		}
		return false;
	}
	
	// Space: O(n) because of the bit array used to check constraints
	// Time: O(n^2) 
	public boolean isValidSudoko(List<List<Integer>> board) {
		
		// check row and column sizes are the same
		if (board.size() != board.get(0).size()) {
			return false;
		}
		
		// check rows
		for (int i = 0; i < board.size(); i++) {
			if (hasDupValues(board, i, i + 1, 0, board.size())) {
				return false;
			}
		}

		// check columns
		for (int j = 0; j < board.size(); j++) {
			if (hasDupValues(board, 0, board.size(), j, j + 1)) {
				return false;
			}
		}
		
		// check regions 
		int regionSize = (int) Math.sqrt(board.size());
		for (int i = 0; i < regionSize; i++) {
			for (int j = 0; j < regionSize; j++) {
				if (hasDupValues(board, regionSize * i, regionSize * (i + 1), regionSize * j, regionSize * (j + 1))) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		List<List<Integer>> board = new ArrayList<>();
		Random rand = new Random();
		
		
	}

}
