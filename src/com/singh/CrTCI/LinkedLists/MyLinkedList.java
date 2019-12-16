package com.singh.CrTCI.LinkedLists;

import java.util.LinkedList;

public class MyLinkedList {

	Node head = null;

	class Node {
		int data;
		Node next;
		Node prev;

		Node(int data) {
			this.data = data;
		}
	}

	public Node search(Node head, int d) {
		Node n = head;
		if (n.data == d) {
			return head;
		}

		while (n.next != null) {
			if (n.next.data == d) {
				return n.next;
			}
			n.next = n.next.next;
		}
		return head;
	}

	public boolean isEmpty() {
		if (head != null) {
			return false;
		}
		return true;
	}

	public Node insertAtHead(Node head, int d) {
		if (!isEmpty()) {
			Node n = head;
			while (n.next != null) {
				n.next.data = n.data;
			}
			head.data = d;
			return head;
		}
		head.data = d;
		return head;
	}

	public Node appendToTail(Node head, int d) {
		if (!isEmpty()) {
			Node n = head;
			while (n.next != null) {
				n = n.next;
			}
			n.data = d;
			return head;
		}
		head.data = d;
		return head;
	}

	public Node delete(Node head, int d) {
		if (!isEmpty()) {
			Node n = head;
			if (n.data == d) {
				return head.next;
			}
			while (n.next != null) {
				if (n.next.data == d) {
					n.next = n.next.next;
					return head;
				}
				n = n.next;
			}
			System.out.println(d + " is not found in " + head);
			return head;
		}
		System.out.println(head + " is empty already.");
		return head;

	}

	public static void main(String[] args) {

	}

}
