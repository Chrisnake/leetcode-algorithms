package easy_leetcode;

public class power_of_two {

    /**
     * Given an integer n, return true if it is a power of two. Otherwise, return false.
     * An integer n is a power of two, if there exists an integer x such that n == 2x.
     * 0, 4, 8, 16
     * 0, 4 - 5
     * 4, 8 -
     */

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(4));
    }

        public static boolean isPowerOfTwo(int n) {
            if(n == 1) return true;
            if(n == 0) return false;
            if(n < 0) return false;
            return traversePowers(0,2,1,n);
        }

        public static boolean traversePowers(double lastPower, double thisPower, int x, int n) {
            boolean isPower;
            if(n == thisPower) {
                isPower = true;
            } else if (n > lastPower && n < thisPower) {
                isPower = false;
            } else {
                isPower = traversePowers(thisPower, Math.pow(2, ++x), x, n);
            }
            return isPower;
        }
}
