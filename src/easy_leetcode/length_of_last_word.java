package easy_leetcode;

public class length_of_last_word {

    /**
     * Given a string s consisting of words and spaces, return the length of the last word in the string.
     * A word is a maximal substring consisting of non-space characters only.
     */

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("fly me to the moon      "));
    }

    public static int lengthOfLastWord(String s) {
        String[] stringArray = s.trim().split(" ");
        return stringArray[stringArray.length - 1].length();
    }
}
