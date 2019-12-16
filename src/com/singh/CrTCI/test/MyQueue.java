package com.singh.CrTCI.test;

import java.util.NoSuchElementException;

public class MyQueue<T> {
	private static class QueueNode<T> {
		private T data;
		private QueueNode<T> next;

		public QueueNode(T data) {
			this.data = data;
		}
	} // Constructor

	private QueueNode<T> first;
	private QueueNode<T> last;
	
	public void add(T item) {
		QueueNode<T> t = new QueueNode<T>(item);
		if (last != null) {
			last.next = t;
		}
		last = t;
		if (first == null) {
			first = last;
		}
	}
	
	public T remove() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		T data = first.data;
		first = first.next;
		if (first == null) {
			last = null;
		}
		return data;
	}
	
	public T peek() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
	}
	
	public boolean isEmpty() {
		return first == null;
	}

	public static void main(String[] args) {
		MyQueue<Integer> q = new MyQueue<Integer>();
		
		q.add(10);
		q.add(23);
		q.add(8);
		q.add(5);
		q.add(97);
		q.add(84);
		System.out.println(q.remove() + " was removed from te queue");
		System.out.println(q.peek() + " is in the front of the queue");
	}
}
