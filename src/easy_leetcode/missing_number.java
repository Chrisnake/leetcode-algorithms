package easy_leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class missing_number {
    /**
     * Given an array nums containing n distinct numbers in the range [0, n],
     * return the only number in the range that is missing from the array
     * 24 mins - easy solution
     * // 0 1 2 4 5 6 7 8 9
     *
     */

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[] {0,1,2,3,4,6}));
        System.out.println(missingNumber(new int[] {3,0,1}));
    }

    public static int missingNumber(int[] nums) {
        int length = nums.length - 1;

        List<Integer> orderedNums = new ArrayList<>(); // you can't do Arrays.asList() on an array with primitive
        for(int thisNum : nums) {
            orderedNums.add(thisNum);
        }

        Collections.sort(orderedNums); // merge sort - divide and conquer splits up array into 2, then again and again and merged into one.

        if(orderedNums.get(0) != 0) return 0;
        if(orderedNums.get(length) == length) return length + 1;

        int prev = 0;
        for(int i = 1; i <= length; i++) {
            int current = orderedNums.get(i);
            if(current - prev != 1) {
                return orderedNums.get(prev) + 1;
            }
            prev++;
        }
        return -1;
    }
}
