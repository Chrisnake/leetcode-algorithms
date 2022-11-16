package easy_leetcode;

import java.util.Arrays;

public class remove_duplicates_sorted_array {

    /**
     * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element
     * appears only once. The relative order of the elements should be kept the same. Since it is impossible to change the length
     * of the array in some languages, you must instead have the result be placed in the first part of the array nums.
     * More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the
     * final result. It does not matter what you leave beyond the first k elements.
     */

    public static void main(String[] args) {
        removeDuplicates(new int[] { 1, 1, 2});
        removeDuplicatesS(new int[] { 1, 1, 2});
    }

    public static int removeDuplicates(int[] nums) {
        int currentKey = 0;
        int removedCount = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                currentKey = nums[i];
            } else {
                if (currentKey != nums[i]) {
                    currentKey = nums[i];
                } else {
                    removedCount++;
                    nums[i] = 900;
                }
            }
        }

        boolean movedSuccesfully = false;
        while(!movedSuccesfully) {
            for(int i = 0; i < nums.length; i++) {
                if(i != nums.length - 1) {
                    if(nums[i] == 900) {
                        int temp = nums[i];
                        nums[i] = nums[i + 1];
                        nums[i + 1] = temp;
                    }
                }
            }
            boolean internal = true;
            for(int i = nums.length - removedCount; i < nums.length; i++) {
                if(nums[i] != 900) {
                    internal = false;
                } else if(i == nums.length - 1 && internal) {
                    movedSuccesfully = true;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        return removedCount;
    }

    public static int removeDuplicatesS(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i == 0 || n > nums[i-1])
                nums[i++] = n;
        return i;
    }

}
