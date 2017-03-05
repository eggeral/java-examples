package egger.software.ad_examples;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println("== Fibonacci Recursive ==");
        System.out.println(fibonacciRecursive(0) + " -- expected: " + (-1L));
        System.out.println(fibonacciRecursive(1) + " -- expected: " + (1L));
        System.out.println(fibonacciRecursive(2) + " -- expected: " + (1L));
        System.out.println(fibonacciRecursive(3) + " -- expected: " + (2L));
        System.out.println(fibonacciRecursive(4) + " -- expected: " + (3L));
        System.out.println(fibonacciRecursive(5) + " -- expected: " + (5L));
        System.out.println(fibonacciRecursive(6) + " -- expected: " + (8L));
        System.out.println(fibonacciRecursive(20) + " -- expected: " + (6765L));
        //System.out.println(fibonacciRecursive(51) + " -- expected: " + (20365011074L)); // wow that takes really long using the recursive solution!!! (1m)
        //System.out.println(fibonacciRecursive(92) + " -- expected: " + (7540113804746346429L)); // last long before long overflow
        System.out.println();
        System.out.println("== Fibonacci ==");
        System.out.println(fibonacci(0) + " -- expected: " + (-1L));
        System.out.println(fibonacci(1) + " -- expected: " + (1L));
        System.out.println(fibonacci(2) + " -- expected: " + (1L));
        System.out.println(fibonacci(3) + " -- expected: " + (2L));
        System.out.println(fibonacci(4) + " -- expected: " + (3L));
        System.out.println(fibonacci(5) + " -- expected: " + (5L));
        System.out.println(fibonacci(6) + " -- expected: " + (8L));
        System.out.println(fibonacci(20) + " -- expected: " + (6765L));
        System.out.println(fibonacci(51) + " -- expected: " + (20365011074L)); // wow that takes really long using the recursive solution!!! (1m)
        System.out.println(fibonacci(92) + " -- expected: " + (7540113804746346429L)); // last value before long overflow
        System.out.println(fibonacci(93) + " -- expected: " + (-2)); // first value after long overflow
    }


    private static long fibonacciRecursive(long n) {
        if (n <= 0)
            return -1;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    private static long fibonacci(long n) {
        if (n <= 0)
            return -1;
        if (n >= 93) // In Java 8 use Math.addExact
            return -2;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;

        long previous = 1;
        long current = 2;
        for (long idx = 3; idx < n; idx++) {
            long tmp = current;
            current = previous + current;
            previous = tmp;
        }
        return current;
    }
}
