package easy_leetcode;

public class search_insert_position {
    /**
     * Given a sorted array of distinct integers and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     * You must write an algorithm with O(log n) runtime complexity. - this is basically a binary search
     *
     * Start in the middle {1, 2, 3, 4, 5, 6, 8, 9, 10, 11} 7
     *                    *
     *    {1, 2, 3, 4, 5, 6, 8, 9, 10, 11}  -> start = 0, middle = 5, end = 9
     *
     *                          *
     *    {1, 2, 3, 4, 5, 6, 8, 9, 10, 11}  -> start = 5, middle = 7, end = 9
     *
     *                       *
     *    {1, 2, 3, 4, 5, 6, 8, 9, 10, 11} -> start = 5, middle = 6, end = 7
     *
     *    Start in the middle {1, 2, 3, 4, 5, 6, 8, 9, 10, 11}, 15
     *
     *                                       >
     *      s                                *                               e
     *    {[1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 16, 17, 18, 19, 20, 21]} -> start = 0, middle = 10, end = 19
     *
     *                                                       <
     *                                      s                *               e
     *    {1, 2, 3, 4, 5, 6, 8, 9, 10, 11, [12, 13, 14, 16, 17, 18, 19, 20, 21]} -> start = 10, middle = 14, end = 19
     *
     *                                               >
     *                                      s        *       e
     *    {1, 2, 3, 4, 5, 6, 8, 9, 10, 11, [12, 13, 14, 16, 17], 18, 19, 20, 21} -> start = 10, middle = 12, end = 14
     *
     *                                                   =
     *                                               s   *   e
     *    {1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, [14, 16, 17], 18, 19, 20, 21} -> start = 12, middle = 13, end = 14, diff = 1, if target < middle then put in middle, if target is greater middle _ 1
     *
     *    if greater than, the start is the mid point, the end stays the same
     *    if less than, the start stays the same, the end is the midpoint
     *
     *    12 13 14 15
     */

    public static void main(String[] args) {
        //System.out.println(searchInsert(new int[] { 3, 4, 6, 10, 12, 15, 18, 35, 34, 56, 70, 80, 90 }, 81));
        System.out.println(7 / 2);
        System.out.println(10 / 2);
       // System.out.println(cleverSearchInsert((new int[] {1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21 }), 8));
        //System.out.println(cleverSearchInsert((new int[] {1, 3, 5, 6 }), 7));
       // System.out.println(cleverSearchInsert((new int[] {1, 3, 5, 6 }), 5));
        //System.out.println(cleverSearchInsert((new int[] {1, 3, 5, 6}), 2));
        System.out.println(cleverSearchInsert((new int[] {1, 3, 5, 6}), 0));
        System.out.println(cleverSearchInsert((new int[] {1, 3, 5, 6}), 7));

    }

    public static int searchInsert(int[] nums, int target) {
        if (target < nums[0]) {
            return 0;
        }
        for(int i = 0; i < nums.length; i++) {
            if(target == nums[i]) {
                return i;
            } else if (i == nums.length - 1) {
                return nums.length;
            } else if(target > nums[i] && target < nums[i + 1]) {
                return ++i;
            }
        }
        return -1;
    }

    public static int cleverSearchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1, middle = 0;
        while(start <= end) {
            middle = start + (end - start) / 2;
            if(nums[middle] == target) {
                return middle;
            }
            if (target < nums[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return start;
    }
}
