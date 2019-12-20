package com.singh.EPI.Arrays;

import java.util.ArrayList;
import java.util.List;

public class PrimeSieve {
	
	// a prime is if it can only be divided by 1 or itself 
	// 1, 2, 3, 5, 7, 11, 13, 
	
    private static boolean isPrime(int number) {
        if (number == 2 || number == 3) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        int sqrtOfNum = (int) Math.sqrt(number) + 1;
        for (int i = 3; i < sqrtOfNum; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static List<Integer> primeSieve(int n) {
    	List<Integer> primes = new ArrayList<>();
    	for (int i = 0; i <= n; i++) {
    		if (isPrime(i)) {
    			primes.add(i);
    		}
    	}
    	return primes;
    }

	public static void main(String[] args) {
		System.out.println(primeSieve(10000000));
	}

}
