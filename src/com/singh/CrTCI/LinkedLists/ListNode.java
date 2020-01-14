package com.singh.CrTCI.LinkedLists;

public class ListNode<T> {
	public ListNode<T> next;
	public T data;
	
	public ListNode(T data) {
		this.data = data;
		next = null;
	}
}
