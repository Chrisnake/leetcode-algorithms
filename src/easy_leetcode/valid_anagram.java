package easy_leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class valid_anagram {

    /**
     * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     * typically using all the original letters exactly once.
     */

    public static void main(String[] args) {
        System.out.println(isAnagram("aacc", "ccac"));
        System.out.println(isCleverAnagram("test", "sett"));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        char[] first = s.toCharArray();
        char[] second = t.toCharArray();
        for (char thisChar : first) {
            if (!map.containsKey(thisChar)) {
                map.put(thisChar, 0);
            } else {
                map.put(thisChar, map.get(thisChar) + 1);
            }
        }
        for (char thisChar : second) {
            if (!map.containsKey(thisChar)) {
                return false;
            }
        }
       return true;
    }

    public static boolean isCleverAnagram(String s, String t) {
        List<Character> first = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> second = t.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        Collections.sort(first);
        Collections.sort(second);

        return first.equals(second);
    }

}
