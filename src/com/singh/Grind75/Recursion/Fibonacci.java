package src.com.singh.Grind75.Recursion;

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


    public static int fibSeqToNaive(int n) {
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

    public static int fibSeqToDP(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        int[] cache = new int[n];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i < n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n - 1] + cache[n - 2];
    }

    public static int fibSeqIterative

    public static void main(String[] args) {
        System.out.println(fibSeqToNaive(10));
        System.out.println(fibSeqToDP(10));
        System.out.println(fibSeqToNaive(Integer.MAX_VALUE));
        System.out.println(fibSeqToDP(Integer.MAX_VALUE));
    }
}

