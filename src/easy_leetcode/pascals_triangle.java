package easy_leetcode;

import java.util.ArrayList;
import java.util.List;

public class pascals_triangle {

    /**
     * Given an integer numRows, return the first numRows of Pascal's triangle.
     *     [1]       (0)
     *   [1][1]      (0, 1)
     *  [1][2][1]    (0, 1, 2)
     * [1][3][3][1]  (0, 1, 2, 3)
     */

    public static void main(String[] args) {
        System.out.println(generate(3));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        List<List<Integer>> firstLayer = new ArrayList<>();
        firstLayer.add(firstRow);
        return returnLayer(firstLayer, 0, numRows);
    }

    public static List<List<Integer>> returnLayer(List<List<Integer>> currentLayer, int currentRow, int numRows) {
        List<Integer> newLayer = new ArrayList<>();
        if(currentRow == numRows - 1) {
            return currentLayer;
        } else {
            List<Integer> previousLayer = currentLayer.get(currentRow);

            int currentRowSize = currentLayer.size();
            for(int i = 0; i < currentRowSize + 1; i++) {
                if(i == 0 || i == currentRowSize) {
                    newLayer.add(1);
                } else {
                    newLayer.add(previousLayer.get(i - 1) + previousLayer.get(i));
                }
            }
        }
        currentLayer.add(newLayer);
        return returnLayer(currentLayer, ++currentRow, numRows);
    }
}
