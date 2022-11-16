package easy_leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class majority_element {
    /**
     * Given an array nums of size n, return the majority element.
     * The majority element is the element that appears more than ⌊n / 2⌋ times.
     * You may assume that the majority element always exists in the array.
     */

    static final int TEST_CASE_SIZE = 9999999;
    static int highestValue = 0;
    static int highestKey = 0;

    public static void main(String[] args) {
        Random rd = new Random(); // creating Random object
        int[] arr = new int[TEST_CASE_SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(); // storing random integers in an array
        }

        majorityElement(arr);
        supremeMajorityElement(arr);
    }

    // Worse case scenario O(n squared)
    public static int majorityElement(int[] nums) {
        long start = System.currentTimeMillis();
        int highestValue = 0;
        int highestKey = 0;

        Map<Integer,Integer> values = new HashMap();
        for(int thisInt : nums) {
            if(!values.containsKey(thisInt)) {
                values.put(thisInt, 1);
            } else {
                values.put(thisInt, values.get(thisInt) + 1);
                if(values.get(thisInt) > nums.length / 2) {
                    return thisInt;
                }
            }
        }

        for(Map.Entry<Integer,Integer> entry : values.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if(value > highestValue) {
                highestKey = key;
            }
        }

        long end = System.currentTimeMillis();
        long timeTaken = end - start;
        System.out.println("Time Taken O(n squared): " + timeTaken + "ms");
        return highestKey;
    }

    public static int supremeMajorityElement(int[] nums) {
        long start = System.currentTimeMillis();
        Map<Integer,Integer> values = new HashMap<>();
        for(int thisInt : nums) {
            if(!values.containsKey(thisInt)) {
                values.put(thisInt, 1);
                setHighest(thisInt, values.get(thisInt));
            } else {
                values.put(thisInt, values.get(thisInt) + 1);
                if(values.get(thisInt) > nums.length / 2) {
                    return thisInt;
                } else {
                    setHighest(thisInt, values.get(thisInt));
                }
            }
        }
        long end = System.currentTimeMillis();
        long timeTaken = end - start;
        System.out.println("Time Taken O(n): " + timeTaken + "ms");
        return highestKey;
    }

    public static void setHighest(int currentKey, int currentValue) {
        if(currentValue > highestValue) {
            highestKey = currentKey;
            highestValue = currentValue;
        }
    }


}
