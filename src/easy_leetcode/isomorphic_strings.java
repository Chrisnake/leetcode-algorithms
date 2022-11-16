package easy_leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class isomorphic_strings {
    /**
     * Given two strings s and t, determine if they are isomorphic.
     * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
     * All occurrences of a character must be replaced with another character while preserving the order of characters.
     * No two characters may map to the same character, but a character may map to itself.
     * <p>
     * Example 1:
     * Input: s = "egg", t = "add"
     * Output: true
     * <p>
     * Example 2:
     * Input: s = "foo", t = "bar"
     * Output: false
     * <p>
     * Example 3:
     * Input: s = "paper", t = "title"
     * Output: true
     *
     *  // hashmap with chars
     */

    public static void main(String[] args) {
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("badc", "baba"));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char main = s.charAt(i);
            char second = t.charAt(i);
            if(!map.containsKey(main)) {
                if(map.containsValue(second)) {
                    return false;
                }
                map.put(main, second);
            } else {
                if(second != map.get(main)) {
                    return false;
                }
            }
        }
        return true;
    }
}
