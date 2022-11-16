package easy_leetcode;

public class highest_common_prefix {
    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     * If there is no common prefix, return an empty string "".
     * Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     *
     * Go through each string at position 0
     * First iteration add first char 'f', if other two also have 'f' move on to position 1
     * else return ""
     * Second iteration append 'l', if other two also have 'l' move on to position 2
     * Third iteration append 'o' if other two also have 'o' move on to position 3, in this case no so return fl.
     */

    public static void main(String[] args) {
   //     System.out.println(longestCommonPrefix(new String[] { "fl","flow","floght", "flsatstheboat"}));
    //    System.out.println(longestCommonPrefix(new String[] { "geeksforgeeks", "geeks", "geek", "geezer" }));
        System.out.println(longestCommonPrefix(new String[] { "flower","flower","flower","flower" }));
    }

    public static String longestCommonPrefix(String[] strs) {
        boolean stopScanning = false;
        String commonPrefix = "";
        int eachCharIter = 0;
        while (!stopScanning) {
            if(strs.length == 1) {
                return strs[0];
            }
            for(int i = 0; i < strs.length; i++) {
                String currentString = strs[i];
                if(currentString.length() -1 == eachCharIter) {
                    stopScanning = true;
                }
                if(currentString.isEmpty()) {
                    stopScanning = true;
                    break;
                }
                String currentPrefix = currentString.substring(0, eachCharIter + 1);
                if(i == 0) {
                    commonPrefix += currentString.substring(eachCharIter, eachCharIter + 1); // get the first ever entry point and add to common prefix
                } else if(!commonPrefix.equals(currentPrefix)) {
                    stopScanning = true;
                    commonPrefix = commonPrefix.substring(0, eachCharIter);
                    break;
                }
                if(i == strs.length - 1) {
                    eachCharIter++;
                }
            }
        }
        return commonPrefix;
    }
}
