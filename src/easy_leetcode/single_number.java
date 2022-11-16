package easy_leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class single_number {
    /**
     * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     * You must implement a solution with a linear runtime complexity and use only constant extra space
     */

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] { 3, 2, 2 }));
    }
    public static int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
            } else {
                list.remove((Integer) num);
            }
        }
        return list.get(0);
    }
}
