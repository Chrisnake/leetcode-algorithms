package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class quick_sort {
    /**
     * QuickSort is a Divide and Conquer algorithm. It picks an element as a pivot and partitions the given array around the picked pivot.
     *
     */

    public static void main(String[] args) {
        quickSort(new int[] { 1, 3, 5, 3, 5, 3, 9});
    }

    public static void quickSort(int[] array) {
        Random random = new Random();
        int currentPivot = random.nextInt(array.length);
        int[] sortedArray = new int[array.length];
        List<Integer> lhs = new ArrayList<>();
        List<Integer> rhs = new ArrayList<>();
        boolean sorted = false;

        while(!sorted) {
            for(int i = 0; i < array.length; i++) {
                if(i != currentPivot) {
                    if(array[i] > array[currentPivot]) {
                        rhs.add(array[i]);
                    } else {
                        lhs.add(array[i]);
                    }
                }
            }
        }

    }
}
