package com.singh.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Remove_Dup_LinkedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		Set<Integer> hashSet = new HashSet<Integer>();
		if (head == null) {
			System.out.println("Empty linked list");
		}
		hashSet.add(head.val);
		ListNode n = head;
		while (n.next != null) {
			if (hashSet.contains(n.next.val)) {
				n = n.next.next;
			} else {
				hashSet.add(n.next.val);
				n = n.next;
			}
		}
		head = n;
		return head;
	}

}
