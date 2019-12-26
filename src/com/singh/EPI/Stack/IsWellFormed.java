package com.singh.EPI.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class IsWellFormed {
	
	public static boolean isWellFormed(String str) {
		Deque<Character> charStack = new ArrayDeque<>();
		Map<Character, Character> MAP_WELLFORMED = new HashMap<>();
		MAP_WELLFORMED.put('(', ')');
		MAP_WELLFORMED.put('[', ']');
		MAP_WELLFORMED.put('{', '}');
		for (int i = 0; i < str.length(); i++) {
			if (MAP_WELLFORMED.get(str.charAt(i)) != null) {
				charStack.addFirst(str.charAt(i));
			} else if (charStack.isEmpty() || MAP_WELLFORMED.get(charStack.removeFirst()) != str.charAt(i)) {
				return false;
			}
		}
		
		return charStack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isWellFormed("([]){()}"));
		System.out.println(isWellFormed("[()[]{()()}]"));
		System.out.println(isWellFormed("{)"));
		System.out.println(isWellFormed("{{(})"));
		System.out.println(isWellFormed("[()[]{()()"));

	}

}
