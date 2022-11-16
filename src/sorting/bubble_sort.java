package sorting;

import java.util.Arrays;

public class bubble_sort {

    /**
     * Repeatedly steps through the list to be sorted, compares each pair of adjacent items and swaps them if they are in the wrong order.
     * The pass through the list is repeated until no swaps are needed, which indicates that the list is sorted.
     *
     * Example: [3, 5, 7, 2]
     * First pass - [7, 5, 2, 7]
     * Second pass - [3, 2, 5, 7]
     */

    public static void main(String[] args) {
        bubbleSort(new int[] {1, 4, 8, 2, 4, 5, 0, -1});
    }

    public static void bubbleSort(int[] numbers) {
        PASS_LOOP: for(int pass = 0; pass < numbers.length; pass++) {
            System.out.println("-------------------------- PASS " + pass + "  --------------------------------");
            int noSwapCount = 0;
            for(int i = 0; i < numbers.length - 1; i++) {
                int currentPos = numbers[i];
                int adjacentPos = numbers[i + 1];
                if(currentPos > adjacentPos) { // swap
                    numbers[i] = adjacentPos;
                    numbers[i + 1] = currentPos;
                } else {
                    noSwapCount++;
                }

                if(noSwapCount == numbers.length - 1) {
                    break PASS_LOOP;
                }

                System.out.println(Arrays.toString(numbers));
            }
        }
        System.out.println(Arrays.toString(numbers));
    }
}
