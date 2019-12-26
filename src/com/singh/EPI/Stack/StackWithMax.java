package com.singh.EPI.Stack;

import java.util.Random;

import com.singh.EPI.LinkedLists.MyLinkedList.ListNode;

public class StackWithMax {
	
	public static int stackWithMax(ListNode<Integer> list) {
		int maxNum = 0;
		while (list != null) {
			if (list.data > maxNum) {
				maxNum = list.data;
			}
			
			list = list.next;
		}
		return maxNum;
	}

	public static void main(String[] args) {
		Random rand = new Random();
		ListNode<Integer> head = new ListNode<Integer>(rand.nextInt(100));
		head.next = new ListNode<Integer>(rand.nextInt(100));
		head.next.next = new ListNode<Integer>(rand.nextInt(100));
		head.next.next.next = new ListNode<Integer>(rand.nextInt(100));
		head.next.next.next.next = new ListNode<Integer>(rand.nextInt(100));
		
		PrintLinkedListInReverse.printlist(head);
		System.out.println(stackWithMax(head));
	}

}
