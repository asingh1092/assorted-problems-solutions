package com.singh.EPI.LinkedLists;

import java.util.Arrays;
import java.util.List;

import javax.xml.stream.EventFilter;

import com.singh.EPI.LinkedLists.MyLinkedList.ListNode;

public class EvenOddMerge {

	public static ListNode<Integer> evenOddMerge(ListNode<Integer> L) {
		if (L == null) {
			return L;
		}

		ListNode<Integer> odd = L;
		ListNode<Integer> even = L.next;
		ListNode<Integer> firstEven = even;

		while (true) {
			if (odd == null || even == null || even.next == null) {
				odd.next = firstEven;
				break;
			}
			odd.next = even.next;
			odd = even.next;
			
			if (odd.next == null) {
				even.next = null;
				odd.next = firstEven;
				break;
			}
			
			even.next = odd.next;
			even = odd.next;
		}

		return L;
	}

	public static ListNode<Integer> evenOddMergeEPI(ListNode<Integer> L) {
		if (L == null) {
			return L;
		}
		ListNode<Integer> evenDummyHead = new ListNode<Integer>(0, null);
		ListNode<Integer> oddDummyHead = new ListNode<Integer>(0, null);
		List<ListNode<Integer>> tails = Arrays.asList(evenDummyHead, oddDummyHead);

		int turn = 0;
		for (ListNode<Integer> iter = L; iter != null; iter = iter.next) {
			tails.get(turn).next = iter;
			tails.set(turn, tails.get(turn).next);
			turn ^= 1;
		}
		tails.get(1).next = null;
		tails.get(0).next = oddDummyHead.next;
		return evenDummyHead.next;
	}

	public static <T> void printlist(ListNode<T> node) {
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println("NULL");
	}

	public static void main(String[] args) {
		ListNode<Integer> head = new ListNode<Integer>(1);
		head.next = new ListNode<Integer>(2);
		head.next.next = new ListNode<Integer>(3);
		head.next.next.next = new ListNode<Integer>(4);
		head.next.next.next.next = new ListNode<Integer>(5);

		System.out.println("Given Linked List");
		printlist(head);

		head = evenOddMergeEPI(head);

		System.out.println("Modified Linked List");
		printlist(head);
		
		ListNode<Integer> head2 = new ListNode<Integer>(1);
		head2.next = new ListNode<Integer>(2);
		head2.next.next = new ListNode<Integer>(3);
		head2.next.next.next = new ListNode<Integer>(4);
		head2.next.next.next.next = new ListNode<Integer>(5);

		System.out.println("Given Linked List");
		printlist(head2);

		head2 = evenOddMerge(head2);

		System.out.println("Modified Linked List");
		printlist(head2);
	}

}
