package easy_leetcode;

public class root_sum {
    /**
     * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that
     * adding up all the values along the path equals targetSum. A leaf is a node with no children.
     *
     * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
     * Output: true
     * Explanation: The root-to-leaf path with the target sum is shown.
     *
     * One of my favourite ones this one
     */

    public static void main(String[] args) {
        TreeNode thirdLayerLeft = new TreeNode(7, null, null);
        TreeNode thirdLayerRight = new TreeNode(2, null, null);
        TreeNode secondLayerLeft = new TreeNode(11, thirdLayerLeft, thirdLayerRight);
        TreeNode firstLayerLeft = new TreeNode(4, secondLayerLeft, null);

        TreeNode thirdLayerRight2 = new TreeNode(1, null, null);
        TreeNode secondLayerRight2 = new TreeNode(4, null, thirdLayerRight2);
        TreeNode secondLayerLeft2 = new TreeNode(13, null, null);
        TreeNode firstLayerRight = new TreeNode(8, secondLayerLeft2, secondLayerRight2);

        TreeNode root = new TreeNode(5, firstLayerLeft, firstLayerRight);
        TreeNode rootEmpty = new TreeNode();

        System.out.println(root);
        System.out.println(hasPathSum(root,23));
        System.out.println(hasPathSum(rootEmpty,1));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return traverse(root, 0, targetSum);
    }

    public static boolean traverse(TreeNode current, int currentSum, int targetSum) {
        boolean found = false;
        // stopping condition
        if(current.left == null && current.right == null) {
            currentSum += current.val;
            found = currentSum == targetSum;
        } else {
            currentSum += current.val;
            if(current.left != null) {
                found = traverse(current.left, currentSum, targetSum);
                if(found) return true;
            }
            if(current.right != null) {
                found = traverse(current.right, currentSum, targetSum);
                if(found) return true;
            }
        }
        return found;
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

        @Override
        public String toString() {
            return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
        }
    }
}
