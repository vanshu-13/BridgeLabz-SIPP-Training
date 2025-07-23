package runtimeAnalysis;

public class FibonacciComparison {

    public static void main(String[] args) {
        int[] testValues = {10, 30, 50};

        for (int n : testValues) {
            System.out.println("Calculating Fibonacci of " + n);

            long startRecursive = System.nanoTime();
            try {
                long resultRecursive = fibonacciRecursive(n);
                long endRecursive = System.nanoTime();
                double timeMs = (endRecursive - startRecursive) / 1_000_000.0;
                System.out.printf("Recursive Result: %d, Time: %.3f ms%n", resultRecursive, timeMs);
            } catch (StackOverflowError e) {
                long endRecursive = System.nanoTime();
                double timeMs = (endRecursive - startRecursive) / 1_000_000.0;
                System.out.printf("Recursive approach for N=%d caused StackOverflow. Time: %.3f ms%n", n, timeMs);
            }

            long startIterative = System.nanoTime();
            long resultIterative = fibonacciIterative(n);
            long endIterative = System.nanoTime();
            double timeMsIterative = (endIterative - startIterative) / 1_000_000.0;
            System.out.printf("Iterative Result: %d, Time: %.3f ms%n", resultIterative, timeMsIterative);

            System.out.println("---------------------------------------------------");
        }
    }

    public static long fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static long fibonacciIterative(int n) {
        if (n <= 1)
            return n;
        long a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}