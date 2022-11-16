package easy_leetcode;

import java.util.Arrays;

public class reverse_string {
    /**
     * Write a function that reverses a string. The input string is given as an array of characters s.
     * You must do this by modifying the input array in-place with O(1) extra memory.
     *
     * Input: s = ["h","e","l","l","o"]
     * Output: ["o","l","l","e","h"]
     */

    public static void main(String[] args) {
        reverseString(new char[] {'h','e','l','p','o'});
    }

    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length;
        System.out.println(s.length / 2);
        for(int i = 0; i < s.length / 2; i++) {
            char tempEnd = s[end - 1];
            char tempStart = s[start];
            s[start++] = tempEnd;
            s[end-- - 1] = tempStart;
        }
        System.out.println(Arrays.toString(s));
    }
}
