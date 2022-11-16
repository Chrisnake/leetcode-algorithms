package easy_leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class reverse_vowels {

    /**
     * Given a string s, reverse only all the vowels in the string and return it.
     * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
     *
     *  l a e o l
     *  l o e a l
     *
     *  a e o u
     *  u o e a
     *
     *  aaa
     */

    static Set<Character> vowelsSet = new HashSet<>();

    static {
        vowelsSet.add('A');
        vowelsSet.add('E');
        vowelsSet.add('I');
        vowelsSet.add('O');
        vowelsSet.add('U');
        vowelsSet.add('a');
        vowelsSet.add('e');
        vowelsSet.add('i');
        vowelsSet.add('o');
        vowelsSet.add('u');
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("laeol"));
        System.out.println(reverseVowels("paaap"));
        System.out.println(reverseVowels("PSDER"));
    }

    public static String reverseVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        Set<Integer> vowelPositions = new LinkedHashSet<>();

        char[] stringArray = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            char thisChar = stringArray[i];
            if (vowelsSet.contains(thisChar)) {
                vowels.add(thisChar);
                vowelPositions.add(i);
            }
        }
        Collections.reverse(vowels);

        int vowelIter = 0;
        for(int thisPos : vowelPositions) {
            stringArray[thisPos] = vowels.get(vowelIter);
            vowelIter++;
        }
        return String.valueOf(stringArray);
    }
}
