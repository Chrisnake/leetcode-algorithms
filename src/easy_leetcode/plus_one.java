package easy_leetcode;

import java.util.Arrays;

public class plus_one {
    /**
     * You are given a large integer represented as an integer array digits, where each digit[i] is the ith digit of the integer.
     * The digits are ordered from most significant to the least significant in left-to-right order.
     * The large integer does not contain any leading 0's.
     * Increment the large integer by one and return the resulting array of digits
     *
     *  Edge case
     *   [9] + 1 = 10
     *   [1,9,9] + 1 = 200
     *   [1,0,9] + 1 = 200
     *   [1,8,9] + 1 = 190
     *   [9,9,9] + 1 = 1000
     *   [9,8,9] + 1 = 990
     *
     *  IF THE NEXT ONE ISNT A 9 THEN ALL GOOD
     *  IF IT IS A 9 CHECK AGAIN IF IT'S A 9, IF IT IS CHECK AGAIN IF IT'S A 9
     *   So, seems if the last digit in the array is a 9 we increment the left digit by 1, again if that is a 9 then we increment that up
     *   we do this until the start of the array.
     */

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3}))); //easy
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9}))); //edge case easy
        System.out.println(Arrays.toString(plusOne(new int[]{9}))); //edge case easy
        System.out.println(Arrays.toString(plusOne(new int[]{9,9}))); //edge case easy
        System.out.println(Arrays.toString(plusOne(new int[]{9,9, 9}))); //edge case easy
        System.out.println(Arrays.toString(plusOne(new int[]{9,9, 9,9}))); //edge case easy

    }

    public static int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while(true) {
            if(digits[i] != 9) {
                digits[i] = digits[i] + 1;
            } else {
                if(digits.length == 1) {
                    return new int[] {1,0};
                }
                int nineCount = 1;
                i--;
                while(digits[i] == 9) {
                    nineCount++;
                    if(i == 0 && nineCount == digits.length) {
                        int[] full = new int[digits.length + 1];
                        if(digits[0] == 9) {
                            full[0] = 1;
                            for(int fill = 1; fill < digits.length + 1; fill++) {
                                full[fill] = 0;
                            }
                        } else {
                            full[0] = digits[0] + 1;
                            for(int fill = 1; i < digits.length; i++) {
                                full[fill] = 0;
                            }
                        }
                        return full;
                    } else {
                        if(digits[i - 1] != 9) {
                            digits[i - 1] = digits[i - 1] + 1;
                            for(int fill = i ; fill < digits.length; fill++) {
                                digits[fill] = 0;
                            }
                            return digits;
                        }
                        i--;
                    }
                }
                digits[i] = digits[i] + 1;
                digits[i + 1] = 0;
            }
            return digits;
        }
    }
}
