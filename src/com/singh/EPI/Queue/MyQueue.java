package com.singh.EPI.Queue;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class MyQueue {

	public static class Queue {
		private Deque<Integer> queue = new ArrayDeque<>();

		public void enqueue(Integer n) {
			queue.add(n);
		}
		
		public Integer dequeue() {
			return queue.removeFirst();
		}
		
		public Integer max() {
			return Collections.max(queue);
		}

	}
}
