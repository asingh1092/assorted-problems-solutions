package com.singh.EPI.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueFromStacks {

	public static class Queue {
		private Deque<Integer> enqueue = new ArrayDeque<>();
		private Deque<Integer> dequeue = new ArrayDeque<>();

		// enqueue
		public void enqueueStack(Integer n) {
			enqueue.addFirst(n);
		}

		// deqeue
		public Integer dequeueStack() {
			if (!dequeue.isEmpty()) {
				return dequeue.removeFirst();
			} else {
				while (!enqueue.isEmpty()) {
					dequeue.addFirst(enqueue.removeFirst());
				}
				return dequeue.removeFirst();
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
