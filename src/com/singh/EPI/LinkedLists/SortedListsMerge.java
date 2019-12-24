package com.singh.EPI.LinkedLists;

import com.singh.EPI.LinkedLists.MyLinkedList.ListNode;

public class SortedListsMerge {
	
	public ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> list1, ListNode<Integer> list2) {
		ListNode<Integer> dummyHead = new ListNode<Integer>(0, null);
		ListNode<Integer> current = dummyHead;
		while (list1 != null && list2 != null) {
			if (list1.data <= list2.data) {
				current.next = list1;
				list1 = list1.next;
			} else {
				current.next = list2;
				list2 = list2.next;
			}
			current = current.next;
		}
		
		// append the remaining nodes of list1 or list2
		current.next = list1 != null ? list1 : list2;
		return dummyHead.next;
	}

}
