package com.singh.EPI.PrimitiveTypes;

public class ReverseBits {
	private static long[] precomputedReverse = new long[(1 << 16)];

	public static long reverseBits(long x) {
		final int MASK_SIZE = 16;
		final int BIT_MASK = 0xFFFF;
		return precomputedReverse[(int) (x & BIT_MASK)] << (3 * MASK_SIZE)
				| precomputedReverse[(int) ((x >>> MASK_SIZE) & BIT_MASK)] << (2 * MASK_SIZE)
				| precomputedReverse[(int) ((x >>> (2 * MASK_SIZE)) & BIT_MASK)] << MASK_SIZE
				| precomputedReverse[(int) ((x >>> (3 * MASK_SIZE)) & BIT_MASK)];
	}
	
	
	public static void main(String args[]) {
		long result = reverseBits(10101110);
		System.out.println(result);
	}

}
