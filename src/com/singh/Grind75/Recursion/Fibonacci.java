package src.com.singh.Grind75.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    /*
        Return a list of fibonacci numbers up to N
        0, 1, 1, 2, 3, 5

        Base case: fib(1) = 0 & fib(2) = 1
        fib(3) = 1 = fib(2) + fib(1)
        fib(4) = 2 = fib(3) + fib(2)
        fib(5) = 3 = fib(4) + fib(3)
        .
        .
        .
        fib(n) = fib(n - 1) + fib(n - 2)
        classic recursion problem

        naive approach -> base case + exploit the fact that fib(n) = fib(n - 1) + fib(n -2)
        dynamic programming approach
     */


    /*
        Time: O(n)
        Space: O(n) -> where n is the size of the recursion tree
     */
    public int fibSeqToNaive(int n) {
        if (n < 0) {
            // return empty}
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibSeqToNaive(n - 1) + fibSeqToNaive(n - 2);
    }

    public int fibSeqToDP(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        if (n <= 1) {
            return cache[n];
        }
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }

    public int fibSeqToIterative(int n) {
        int first = 0;
        int second = 1;
        int ret = 0;
        for (int i = 2; i <= n; i++) {
            ret = first + second;
            first = second;
            second = ret;
        }
        return ret;
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println(fib.fibSeqToNaive(10));
        System.out.println(fib.fibSeqToDP(10));
        System.out.println(fib.fibSeqToDP(1));
        System.out.println(fib.fibSeqToIterative(10));
        //System.out.println(fibSeqToNaive(9999)); // really damn slow
        System.out.println(fib.fibSeqToDP(9999));
        System.out.println(fib.fibSeqToIterative(9999));
    }
}

