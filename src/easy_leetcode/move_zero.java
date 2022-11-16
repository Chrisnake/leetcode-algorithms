package easy_leetcode;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class move_zero {

    /**
     * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * Note that you must do this in-place without making a copy of the array.
     */

    public static void main(String[] args) {
        moveZeroes(new int[] {0,1,0,3,12});
    }

    public static void moveZeroes(int[] nums) {
        Map<Integer, Integer> store = new TreeMap<>(); //key = position, value = value toput
        int order = 0;
        for (int num : nums) {
            if (num != 0) {
                store.put(order, num);
                order++;
            }
        }

        int leftOverZeros = nums.length - store.size();
        int indexToStop = (nums.length) - leftOverZeros;
        for (int i = 0; i < nums.length; i++) {
            if (indexToStop > i) {
                nums[i] = store.get(i);
            } else {
                nums[i] = 0;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}