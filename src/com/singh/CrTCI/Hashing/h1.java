package com.singh.CrTCI.Hashing;

import java.util.ArrayList;

public class h1<K, V> {

	public class h1Node<K, V> {
		K key;
		V value;
		h1Node<K, V> next;

		public h1Node(K key, V value) {
			this.key = key;
			this.value = value;
			next = null;
		}
	}

	private int h1BucketSize;
	private int size;
	private h1Node[] h1Table;

	public h1() {
		h1BucketSize = 10;
		size = 0;
		h1Table = new h1Node[h1BucketSize];

		for (int i = 0; i < h1BucketSize; i++) {
			h1Table[i] = null;
		}
	}

	private int getBucketIndex(K key) {
		int hashCode = key.hashCode();
		int index = hashCode % h1BucketSize;
		return index;
	}
	
	public V remove(K key) {
		return null;
	}
	// get
	// remove
	// put
}
