package com.singh.CrTCI.LinkedLists;

public class Palindrome {
	
	private class ListNode<T> {
		private ListNode<T> next;
		private ListNode<T> prev;
		private T data;
		
		public ListNode(T data) {
			this.data = data;
			next = null;
			prev = null;
		}
	}
	
	public static boolean isPalindrme(ListNode<Character> head) {
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
