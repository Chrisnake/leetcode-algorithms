package easy_leetcode;

import java.util.Arrays;

public class climbing_stairs {

    /**
     * You are climbing a staircase. It takes n steps to reach the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     *
     * Input: n = 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     * - 1, 1
     * - 2
     *
     * Input: n = 3
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     *  - 1, 1, 1
     *  - 2, 1
     *  - 1, 2

     *  Example - n = 4
     *  - 1, 1, 1, 1
     *
     *  - 1, 2, 1
     *  - 2, 1, 1
     *  - 1, 1, 2
     *  - 1, 1,
     *
     *  - 2, 2
     *
     *  Example - n = 5
     *  - 1, 1, 1, 1, 1
     *
     *  - 2, 2, 1
     *  - 2, 1, 2
     *  - 1, 2, 2
     *
     *  - 2, 1, 1, 1
     *  - 1, 2, 1, 1
     *  - 1, 1, 2, 1
     *  - 1, 1, 1, 2
     *
     *  Brute force recursive method
     *  - Every step we can calculate how many possibilities there can be
     *  - 1 step 1
     *  - 2 steps 11, 2
     *  - 3 steps 111, 12, 21
     *  - 4 steps 1111, 211, 121, 112, 22
     *
     *  - F(n) = F(N - 1) + F(N - 2)
     *  - F(4) = F(3) + F(2)
     *
     *
     *
     *
     *
     *      1
     *   11=
     *  111= 3 (1)
     *
     *
     *
     *
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fibonacci(100)));
        System.out.println(fibonacciCalculatePosition(3));
        recursiveFibonacci(3, 0,0,0);
    }

    public static int climbStairs(int n) {
        return 2;
    }

    /**
     * Write a method to print the first 15 numbers of the fibonacci sequence
     * The Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144.....
     * The first two numbers in the sequence are 0 and 1, and each subsequent number is the sum of the previous two.
     */
    public static long[] fibonacci(int n) {
        long[] fib = new long[n];
        fib[0] = 0;
        fib[1] = 1;
        long previousSum = 1;
        for(int i = 2; i < n; i++) {
            long current = previousSum + fib[i - 2];
            if(current < 0) {
                return fib; // prevent long overflow
            }
            fib[i] = current;
            previousSum = fib[i];
        }
        return fib;
    }

    /**
     * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the
     * sum of the two preceding ones, starting from 0 and 1. That is,
     * <p>
     *  F(0) = 0, F(1) = 1
     *  F(n) = F(n - 1) + F(n - 2), for n > 1.
     * <p>
     *  Given n, calculate F(n).
     */
    public static int fibonacciCalculatePosition(int n) {
        if(n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        int previousSum = 1;
        for(int i = 2; i <= n; i++) {
            int current = previousSum + fib[i - 2];
            if(n == i) {
                return current;
            } else {
                fib[i] = current;
                previousSum = fib[i];
            }
        }
        return -1;
    }

    public static void recursiveFibonacci(int n, int current, int lastValue, int secondLastValue) {
        int thisValue;
        if(n == 0) {
            System.out.println("0");
        } else if (n == 1) {
            System.out.println("1");
        }
        if(current == 0) {
            recursiveFibonacci(n, ++current, 1, 0);
        } else {
            thisValue = lastValue + secondLastValue;
            System.out.println(thisValue);
            if(n == current) {
                System.out.println("This is the value you are searching for: " + thisValue);
            } else {
                recursiveFibonacci(n, ++current, thisValue, lastValue);
            }
        }
    }
}
