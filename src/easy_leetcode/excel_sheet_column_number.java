package easy_leetcode;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class excel_sheet_column_number {
    /**
     * Given a string columnTitle that represents the column title as appears in an Excel sheet,
     * return its corresponding column number.
     * <p>
     * For example:
     * <p>
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * ...
     */

    public static void main(String[] args) {
        int num = 'B';
        int num2 = 'A';
        Queue<Integer> queue = new ArrayBlockingQueue<>(32);
        Iterator<Integer> iterator = queue.iterator();

        while(iterator.hasNext()) {
            int i = iterator.next();
        }
        System.out.println(num);
        System.out.println(num2);
        System.out.println((num - 'A') + 1);
    }

    public int titleToNumber(String columnTitle) {
        return 3;
    }
}
