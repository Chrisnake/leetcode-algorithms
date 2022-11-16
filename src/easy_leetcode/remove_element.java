package easy_leetcode;

import java.util.Arrays;

public class remove_element {

    /**
     * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
     * The relative order of the elements may be changed.
     */

    public static void main(String[] args) {
        removeElement(new int[] { 1,3,2,2,3 }, 3);
    }

    public static int removeElement(int[] nums, int val) {
        int total = 0;
        for(int values : nums) {
            if(values == val) {
                total++;
            }
        }
        if(total == 0) {
             return 0;
        }
        for(int i = 0; i < nums.length; i++) {
            if( i != nums.length - 1) {
                if(nums[i] == val) {
                    int swapPosition = i + 1;
                    int max = nums.length - total;
                    if(i != max) {
                        while(nums[swapPosition] == val) {
                            swapPosition++;
                        }
                        int tempSwap = nums[swapPosition];
                        int tempOrig = nums[i];
                        nums[i] = tempSwap;
                        nums[swapPosition] = tempOrig;
                    } else {
                        return total;
                    }
                }
            }

        }
        return total;
    }
}
