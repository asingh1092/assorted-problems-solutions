package com.singh.EPI.BinaryTrees;

public class TreeTraversal {

	public static void treeTraversal(MyBinaryTreeNode<Integer> root) {
		if (root != null) {
			// PreOrder: Processes the root before the traversals of left and right children
			System.out.println("PreOrder: " + root.getData());
			treeTraversal(root.getLeft());
			// InOrder: Processes the root after the traversal of left child and before the
			// traversal of right child
			System.out.println("PreOrder: " + root.getData());
			treeTraversal(root.getRight());
			// PostOrder: Processes the root after the traversals of left and right children
			System.out.println("PreOrder: " + root.getData());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
