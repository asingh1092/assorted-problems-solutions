package com.singh.CrTCI.LinkedLists;

import com.singh.CrTCI.LinkedLists.ListNode;
import java.util.ArrayDeque;
import java.util.Deque;

public class Palindrome {
	
	public static boolean isPalindrome(ListNode<Character> head) {
		ListNode<Character> slow = head;
		Deque<Character> stack = new ArrayDeque<>();
		
		// Add all characters into a stack
		while (slow != null) {
			stack.push(slow.data);
			slow = slow.next;
		}
		
		// Check head data to stack data values
		while (head != null) {
			if (head.data != stack.pop()) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

	public static void main(String[] args) {
		ListNode<Character> node1 = new ListNode<Character>('w');
		ListNode<Character> node2 = new ListNode<Character>('o');
		ListNode<Character> node3 = new ListNode<Character>('t');
		node1.next = node2;
		node2.next = node3;
		System.out.println("Is this a palindrome?: " + isPalindrome(node1));
		
		ListNode<Character> node4 = new ListNode<Character>('w');
		ListNode<Character> node5 = new ListNode<Character>('o');
		ListNode<Character> node6 = new ListNode<Character>('w');
		node4.next = node5;
		node5.next = node6;
		System.out.println("Is this a palindrome?: " + isPalindrome(node4));

	}
}


