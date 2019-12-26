package com.singh.EPI.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class MyStack {

	private static class ElementWithCachedMax {
		public Integer element;
		public Integer max;

		public ElementWithCachedMax(Integer element, Integer max) {
			this.element = element;
			this.max = max;
		}
	}

	public static class Stack {
		// this arrayDeque will store (element, cached maximum) pair
		private Deque<ElementWithCachedMax> elementWithCachedMax = new ArrayDeque<>();

		public boolean empty() {
			return elementWithCachedMax.isEmpty();
		}

		public Integer max() {
			return elementWithCachedMax.peek().max;
		}

		public Integer pop() {
			return elementWithCachedMax.removeFirst().element;
		}

		private static boolean isDuplicate(Integer n) {
			Set<Integer> hSet = new HashSet<Integer>();
			if (!hSet.contains(n)) {
				hSet.add(n);
				return false;
			}
			return true;
		}

		public void push(Integer n) {
			if (isDuplicate(n)) {
				elementWithCachedMax.addFirst(new ElementWithCachedMax(n, null));
			} else {
				elementWithCachedMax.addFirst(new ElementWithCachedMax(n, Math.max(n, empty() ? n : max())));
			}
		}
	}
	
	public static void main(String args[]) {
		
	}
}
