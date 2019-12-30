package com.singh.EPI.Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import javax.sound.midi.Sequence;

public class OnlineMedian {

	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public static List<Double> onlineMedian(Iterator<Integer> sequence) {
		// minHeap stores the larger half seen so far
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		// maxHeap stores the smaller half seen so far
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(DEFAULT_INITIAL_CAPACITY, Collections.reverseOrder());
		List<Double> result = new ArrayList<>();
		while (sequence.hasNext()) {
			int n = sequence.next();
			minHeap.add(n);
			maxHeap.add(minHeap.remove());
			// Ensure minHeap and maxHeap have equal number of elements forr even number of elements
			// else, minHeap has one more element than maxHeap
			if (maxHeap.size() > minHeap.size()) {
				minHeap.add(maxHeap.remove());
			}
			result.add(((minHeap.size() == maxHeap.size()) ? 0.5 * (minHeap.peek() + maxHeap.peek())
					: (double) minHeap.peek()));
		}
		return result;
	}

}
