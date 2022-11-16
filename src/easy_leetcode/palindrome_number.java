package easy_leetcode;

public class palindrome_number {

    /**
     *  Given an integer x, return true if x is palindrome integer.
     *  An integer is a palindrome when it reads the same backward as forward.
     *  For example, 121 is a palindrome while 123 is not. 321123
     */

    public static void main(String[] args) {
        System.out.println(isPalindrome(234234));
    }

    public static boolean isPalindrome(int x) {
        String input = String.valueOf(x);
        int inverse = input.length() - 1;
        for(int i = 0; i < input.length() / 2 ; i++) {
            if(input.charAt(i) != input.charAt(inverse)) {
                return false;
            }
            inverse--;
        }
        return true;
    }
}
