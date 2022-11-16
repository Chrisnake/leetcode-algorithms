package easy_leetcode;

import java.util.ArrayList;
import java.util.List;

public class split_bill {

    /**
     * Two friends Anna and Brian, are deciding how to split the bill at a dinner. Each will only pay for the items they consume.
     *  Brian gets the check and calculates Anna's portion. You must determine if his calculation is correct.
     */

    public static void main(String[] args) {
        List<Integer> bill = new ArrayList<>();
        bill.add(3);
        bill.add(10);
        bill.add(2);
        bill.add(9);
        bonAppetit(bill, 1, 12);
    }

    public static void bonAppetit(List<Integer> bill, int k, int b) {
        int annaBillCount = 0;
        for(int i = 0; i < bill.size(); i++) {
            if(i != k) {
                annaBillCount = annaBillCount + bill.get(i);
            }
        }
        int diff = b - (annaBillCount / 2);
        if(diff == 0) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println("Brian owes " + diff);
        }
    }

}
