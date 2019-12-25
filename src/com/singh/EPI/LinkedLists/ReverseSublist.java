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
		
		ListNode<Integer> dummyHead = new ListNode<>(0, list);
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
			start++;
		}
		
		return dummyHead.next;
	}
	
	public ListNode<Integer> reverseListIteratively(ListNode<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode<Integer> reversedList = head;
		ListNode<Integer> listIter = head.next;
		
		while (listIter != null) {
			ListNode<Integer> temp = listIter;
			listIter = listIter.next;
			temp.next = reversedList;
			reversedList = temp;
		}
		
		return head;
	}
	
	public ListNode<Integer> reverseList(ListNode<Integer> list) {
		ListNode<Integer> prevNode = null;
		ListNode<Integer> current = list;
		ListNode<Integer> nextNode = null;
		
		while (current != null) {
			nextNode = current.next;
			current.next = prevNode;
			prevNode = current;
			current = nextNode;
		}
		list = prevNode;
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
