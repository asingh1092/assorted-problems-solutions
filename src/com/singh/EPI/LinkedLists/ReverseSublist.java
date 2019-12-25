package com.singh.EPI.LinkedLists;

import java.util.List;

import com.singh.EPI.LinkedLists.MyLinkedList.ListNode;

public class ReverseSublist {
	
	// Time: O(finish)
	// Space: O(1)
	public static ListNode<Integer> reverseSublist(ListNode<Integer> list, int start, int fin) {
		if (start < fin) {
			return list;
		}
		
		ListNode<Integer> dummyHead = new ListNode<>(0, null);
		ListNode<Integer> sublistHead = dummyHead;
		
		// find start of sublist
		int k = 1;
		while (k < start) {
			sublistHead = sublistHead.next;
			k++;
		}
		
		// now reverse the sublist
		ListNode<Integer> sublistIter = sublistHead.next;
		while (start < fin) {
			ListNode<Integer> temp = sublistIter.next;
			sublistIter.next = temp.next;
			temp.next = sublistHead.next;
			sublistHead.next= temp;
		}
		
		return dummyHead.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
