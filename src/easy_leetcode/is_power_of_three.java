package easy_leetcode;

public class is_power_of_three {

    /**
     * Given an integer n, return true if it is a power of three. Otherwise, return false.
     * An integer n is a power of three, if there exists an integer x such that n == 3x.
     */

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(2147483647));
        int n = 2147483647;
    }

    public static boolean isPowerOfThree(int n) {
        return dive(1, n);
    }

    public static boolean dive(int currentX, int n) {
        boolean power;
        long current = (long) Math.pow(3, currentX);
        if(current == n) {
            power = true;
        } else if(current > n) {
            power = false;
        } else {
            power = dive(++currentX, n);
        }
        return power;
    }
}
