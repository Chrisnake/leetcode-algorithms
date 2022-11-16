package easy_leetcode;

import java.util.HashMap;

public class roman_numericals {

    /**
     *  Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     *
     *  Symbol       Value
     *  I             1
     *  V             5
     *  X             10
     *  L             50
     *  C             100
     *  D             500
     *  M             1000
     *  For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
     *
     *  Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
     *
     *  I can be placed before V (5) and X (10) to make 4 and 9.
     *  X can be placed before L (50) and C (100) to make 40 and 90.
     *  C can be placed before D (500) and M (1000) to make 400 and 900.
     *  Given a roman numeral, convert it to an integer.
     *
     *  Special cases - IV (=4), IX(=9), XL(=40), XC(=90), CD(=400), CM(=900)
     *  XIV = 14, IX = 9, XIX = 19, LXXIV = 74 CMXLII
     */

    static HashMap<Character, Integer> ROMAN_MAP = new HashMap<>();

    static {
        ROMAN_MAP.put('I', 1);
        ROMAN_MAP.put('V', 5);
        ROMAN_MAP.put('X', 10);
        ROMAN_MAP.put('L', 50);
        ROMAN_MAP.put('C', 100);
        ROMAN_MAP.put('D', 500);
        ROMAN_MAP.put('M', 1000);
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {

        int total = 0;
        RomanSpecials romanSpecials;

        if(!checkString(s)) {
            return -1;
        } else {
            romanSpecials = removeSpecials(s);
            for(int i = 0; i < romanSpecials.getFinalString().length(); i++) {
                char thisChar = romanSpecials.finalString.charAt(i);
                total += ROMAN_MAP.get(thisChar);
            }
        }
        return total + romanSpecials.getTotalRemoved();
    }

    static boolean checkString(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(!ROMAN_MAP.containsKey(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    static RomanSpecials removeSpecials(String s) {
        String removeSpecials = s;
        int total = 0;
        if(s.contains("IV")) {
            removeSpecials = removeSpecials.replace("IV", "");
            total += 4;
        }

        if (s.contains("IX")) {
            removeSpecials = removeSpecials.replace("IX", "");
            total += 9;
        }

        if (s.contains("XL")) {
            removeSpecials = removeSpecials.replace("XL", "");
            total += 40;
        }

        if (s.contains("XC")) {
            removeSpecials = removeSpecials.replace("XC", "");
            total += 90;
        }

        if (s.contains("CD")) {
            removeSpecials = removeSpecials.replace("CD", "");
            total += 400;
        }

        if (s.contains("CM")) {
            removeSpecials = removeSpecials.replace("CM", "");
            total += 900;
        }
        return new RomanSpecials(removeSpecials, total);
    }

    static class RomanSpecials {
        private final String finalString;
        private final int totalRemoved;

        RomanSpecials(String finalString, int totalRemoved) {
            this.finalString = finalString;
            this.totalRemoved = totalRemoved;
        }

        public String getFinalString() {
            return finalString;
        }

        public int getTotalRemoved() {
            return totalRemoved;
        }
    }
}
