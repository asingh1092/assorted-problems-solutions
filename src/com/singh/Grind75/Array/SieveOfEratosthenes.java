package src.com.singh.Grind75.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SieveOfEratosthenes {

    /*
        Find all prime numbers up to a given limit n.
     */

    /**
     *  Naive implementation of counting all primes to n.
     *
     *  N = elements to n
     *  Time: O(N^2)
     *  Space: O(N)
     * @param n number up to
     * @return list of primes
     */

    public List<Integer> generatePrimesToNaive(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean isPrime = true;
        // No primes less than 2 so return empty array
        if (n <= 1) {
            return primes;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                isPrime = true;
                if (i % j == 0) {
                    isPrime = false;
                    // not prime
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }
        }
        return primes;
    }

    /*
        Time: O(n * sqrt(n)
        Space: O(sqrt(n))
     */
    public List<Integer> generatePrimesToSqrt(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean isPrime = true;
        if (n <= 1) {
            return Collections.emptyList();
        }

        for (int i = 2; i <= n; i++) {
            /* only need to check up until sqrt(n)
                why? because there exist two pairs of the same coefficients that add up to n
                    half of one of the coefficients are less than sqrt(n) and the other half as well
                    so we can conclude that there if there are any coefficients less than sqrt(n) that
                    make the number not prime, it's other half equivalent should also make the number not prime
            */
            for (int j = 2; j <= Math.sqrt(i); j++) {
                isPrime = true;
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }
        }
        return primes;
    }

    /*
        Time: O(n) + O(n*log(logn)) + O(n) = O(n * log(log(n)))
        Space: O(sqrt(n)
     */
    public List<Integer> generatePrimesToEratosthenes(int n) {
        if (n <= 1) {
            return Collections.emptyList();
        }
        List<Boolean> primes = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            // assume all numbers up until n are prime (yes including 0)
            primes.add(true);
        }
        // we know 0 and 1 are not prime
        primes.set(0, false);
        primes.set(1, false);

        // only need to check up until sqrt n due to the coefficient pair thingy
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primes.get(i)) {
                // set all multiples of value to false because no multiple of i can be prime
                for (int j = 2; i*j <= n; j++) {
                    primes.set(i*j, false);
                }
            }
        }

        List<Integer> primesToReturn = new ArrayList<>((int) Math.sqrt(n));
        for (int p = 0; p <= n; p++) {
            if (primes.get(p)) {
                primesToReturn.add(p);
            }
        }
        return primesToReturn;
    }

    public static void main(String[] args) {
        SieveOfEratosthenes sieve = new SieveOfEratosthenes();
        System.out.println(sieve.generatePrimesToNaive(500));
        System.out.println(sieve.generatePrimesToSqrt(500));
        System.out.println(sieve.generatePrimesToEratosthenes(500));
    }
}
