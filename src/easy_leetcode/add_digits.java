package easy_leetcode;

import java.util.ArrayList;
import java.util.List;

public class add_digits {

    /**
     * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
     * 348 -> 3 + 4 + 8 = 15
     * 15 - > 1 + 5 = 6
     */

    public static void main(String[] args) {
        System.out.println(addDigitsNotSoCleverly(1248));
    }

    public static int addDigitsNotSoCleverly(int num) {
        if(num < 10) return num;

        List<Integer> numToList;
        numToList = convertToList(num);

        while(numToList.size() != 1) {
            int answer = 0;
            for (Integer integer : numToList) {
                answer += integer;
            }
            if(answer < 10) {
                return answer;
            } else {
                numToList = convertToList(answer);
            }
        }
        return -1;
    }

    public static List<Integer> convertToList(int num) {
        List<Integer> numToList = new ArrayList<>();
        char[] characters = String.valueOf(num).toCharArray();
        for(char thisChar : characters) {
            numToList.add(Character.getNumericValue(thisChar));
        }
        return numToList;
    }
}
