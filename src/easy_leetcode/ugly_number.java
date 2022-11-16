package easy_leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ugly_number {

    /**
     * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
     * Given an integer n, return true if n is an ugly number.
     */

    public static void main(String[] args) {
        System.out.println(isUgly(new UglyNode(16, null, null), 16, 16, new HashSet<>()));
    }

    public static boolean isUgly(UglyNode current, int currentVal, int n, Set<Integer> uglyNumbers) {
        boolean prime = true;
        List<Integer> factors = new ArrayList<>();
        for(int i = 1; i < currentVal; i++) {
            if(currentVal % i == 0) {
                factors.add(i);
                prime = false;
            } else {
                uglyNumbers.add(currentVal);
            }
        }
        if(!prime) {
            Map<Integer, Integer> nodes = new HashMap<>();
            for (Integer factor : factors) {
                int x = currentVal / factor;
                nodes.put(x, factor);
            }
        }
        return true;
    }

    public

    static class UglyNode {
        int val;
        UglyNode left;
        UglyNode right;

        UglyNode(int val, UglyNode left, UglyNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
