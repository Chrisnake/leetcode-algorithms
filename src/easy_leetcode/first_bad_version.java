package easy_leetcode;

public class first_bad_version {
    /**
     * You are a product manager and currently leading a team to develop a new product. Unfortunately,
     * the latest version of your product fails the quality check. Since each version is developed based on the previous version,
     * all the versions after a bad version are also bad. Suppose you have n versions [1, 2, ..., n] and you want to find out the
     * first bad one, which causes all the following ones to be bad. You are given an API bool isBadVersion(version) which
     * returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
     2126753390
     1702766719* <p>
     * Example
     * -----------------------------------
     * Input: n = 5, bad = 4
     * Output: 4
     * Explanation:
     * call isBadVersion(3) -> false
     * call isBadVersion(5) -> true
     * call isBadVersion(4) -> true
     * Then 4 is the first bad version.
     */

    public static final int THRESHOLD = 5;
    public int divide(int start, int end) {
        int result;
        long midpoint = ((long) start + end) / 2; // Needed to stop integer overflow when we calculate midpoint
        int midpoint2 = (int) midpoint;
        boolean isBadVersion = isBadVersion(midpoint2);

        if(end - start < THRESHOLD) {
            if(isBadVersion) {
                return getBadVersion(start, midpoint2);
            } else {
                return getBadVersion(midpoint2, end);
            }
        } else if (!isBadVersion) {
            result = divide(midpoint2, end);
        } else {
            result = divide(start, midpoint2);
        }
        return result;
    }

    public int getBadVersion(int start, int end) {
        for(int i = start; i <= end; i++) {
            if(isBadVersion(i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isBadVersion(int midpoint2) {
        return true;
    }
}
