package com.singh.EPI.Heaps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class TopK {

	public static List<String> topk(int k, Iterator<String> iter) {
		PriorityQueue<String> minHeap = new PriorityQueue<>(k, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
		while (iter.hasNext()) {
			minHeap.add(iter.next());
			if (minHeap.size()> k) {
				// Remove the shortest string
				// Note the comparison function above will order the strings by length
				minHeap.poll();
			}
		}
		return new ArrayList<>(minHeap);
	}

}
