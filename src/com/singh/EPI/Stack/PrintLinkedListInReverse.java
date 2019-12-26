package com.singh.EPI.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

import com.singh.EPI.LinkedLists.MyLinkedList.ListNode;

public class PrintLinkedListInReverse {

	public static void printLinkedListInReverse(ListNode<Integer> head) {
		Deque<Integer> nodes = new ArrayDeque<>();
		while (head != null) {
			nodes.addFirst(head.data);
			head = head.next;
		}
		while (!nodes.isEmpty()) {
			System.out.print(nodes.poll() + "->");
		}
		System.out.println("NULL");
	}

	public static <T> void printlist(ListNode<T> node) {
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println("NULL");
	}

	public static void main(String[] args) {
		ListNode<Integer> L = new ListNode<Integer>(1);
		L.next = new ListNode<Integer>(2);
		L.next.next = new ListNode<Integer>(3);
		L.next.next.next = new ListNode<Integer>(4);
		L.next.next.next.next = new ListNode<Integer>(5);
		
		printlist(L);
		printLinkedListInReverse(L);
	}

}
