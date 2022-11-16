package easy_leetcode;

import java.util.HashMap;
import java.util.Map;

public class contains_duplicate {
    /**
     * Given an integer array nums, return true if any value appears at least twice in the array,
     * and return false if every element is distinct.
     */
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] {1,2,3,4,5,6,7}));
    }

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(!map.containsKey(num)) {
                map.put(num, -1);
            } else {
                return true;
            }
        }
        return false;
    }
}
