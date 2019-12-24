package com.singh.EPI.LinkedLists;

public class MyLinkedList<T> {

	public ListNode<T> head;

	public static class ListNode<T> {
		public T data;
		public ListNode<T> next;

		public ListNode(T data, ListNode<T> next) {
			this.data = data;
			this.next = next;
		}

		public ListNode(T data) {
			this.data = data;
		}

		public static <T> ListNode<T> search(ListNode<T> head, T value) {
			while (head.next != null && head.data != value) {
				head = head.next;
			}
			return head;
		}

		public static <T> void insertAtTail(ListNode<T> head, T value) {
			ListNode<T> newNode = new ListNode<T>(value);
			while (head.next != null) {
				head = head.next;
			}
			head.next = newNode;
		}

		public static <T> void insertAt(ListNode<T> node, ListNode<T> newNode) {
			newNode.next = node.next;
			node.next = newNode;
		}

		// Assumes node is not a tail
		public static <T> void deleteAt(ListNode<T> node) {
			node.next = node.next.next;
		}

		public static <T> ListNode<T> delete(ListNode<T> head, T value) {
			if (head.data == value) {
				head = head.next;
				return head;
			}

			while (head.next != null) {
				if (head.next.data == value) {
					head.next = head.next.next;
					return head;
				}
				head = head.next;
			}

			return head;
		}
	}

}
