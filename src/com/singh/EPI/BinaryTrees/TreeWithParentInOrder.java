package com.singh.EPI.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class TreeWithParentInOrder {
	
	// Time: O(n)
	// Space O(1)
	public static List<Integer> inOrderTraversal(MyBinaryTreeNode<Integer> tree) {
		MyBinaryTreeNode<Integer> prev = null;
		MyBinaryTreeNode<Integer> curr = tree;
		List<Integer> result = new ArrayList<>();
		while (curr != null) {
			MyBinaryTreeNode<Integer> next;
			if (curr.getParent() == prev) {
				// We came down to curr from prev
				if (curr.getLeft() == null) {
					// Keep going left
					next = curr.getLeft();
				} else {
					result.add(curr.getData());
					// Done with left so go right if right is not empty
					// Otherwise, we go up one to parent
					next = (curr.getRight() != null) ? curr.getRight() : curr.getParent();
				}
			} else if (curr.getLeft() == prev) {
				result.add(curr.getData());
				// Done with left so go right if right is not empty
				// Otherwise, we go up one to parent
				next = (curr.getRight() != null) ? curr.getRight() : curr.getParent();
			} else {
				next = curr.getParent();
			}
			prev = curr;
			curr = next;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
