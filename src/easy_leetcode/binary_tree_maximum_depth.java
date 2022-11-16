package easy_leetcode;

public class binary_tree_maximum_depth {

    /**
     * Given the root of a binary tree, return its maximum depth.
     * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     * <p>
     *             3
     *           /   \
     *          9    20
     *              /  \
     *             15   7
     *
     *
     *           1
     *             \
     *              2
     *
     *      1   2
     * Input: root = [3,9,20,null,null,15,7]
     *
     *
     *             1
     *          /    \
     *         2      3
     *       /         \
     *      4           5
     *
     *
     * [1,2,3,4,null,null,5]
     * Output: 3
     */

    public static void main(String[] args) {
        TreeNode secondLayerRight = new TreeNode(7, null, null);
        TreeNode secondLayerLeft = new TreeNode(15, null, null);
        TreeNode firstLayerLeft = new TreeNode(20, secondLayerLeft, secondLayerRight);
        TreeNode firstLayerRight = new TreeNode(9, null, null);
        TreeNode root = new TreeNode(3, firstLayerLeft, firstLayerRight);

        //System.out.println(maxDepth(root));
        //System.out.println(highest);

        TreeNode secondLayerRight2 = new TreeNode(5, null, null);
        TreeNode secondLayerLeft2 = new TreeNode(4, null, null);
        TreeNode firstLayerRight2 = new TreeNode(3, null, secondLayerRight2);
        TreeNode firstLayerLeft2 = new TreeNode(2, secondLayerLeft2, null);
        TreeNode root2 = new TreeNode(1, firstLayerLeft2, firstLayerRight2);
        //System.out.println(maxDepth(root2));
        //System.out.println(highest);


        TreeNode firstLayerLeft3 = new TreeNode(2, null, null);
        TreeNode root3 = new TreeNode(1, firstLayerLeft3, null);
        //System.out.println(maxDepth(root3));

        TreeNode firstLayerLeft4 = new TreeNode(2, null, null);
        TreeNode root5 = new TreeNode(1, null, firstLayerLeft4);
        System.out.println(maxDepth(root5));
    }

    static int highest = 0;
    public static int maxDepth(TreeNode root) {
        traverse(root, 0);
        return highest;
    }
    public static int traverse(TreeNode current, int currentDepth) {
        if(current == null) {
            return currentDepth;
        }
        currentDepth++;
        if(current.left == null && current.right == null) {
            if(currentDepth > highest) {
                highest = currentDepth;
            }
            return currentDepth;
        } else if (current.left == null) {
            traverse(current.right, currentDepth);
        } else if (current.right == null) {
            traverse(current.left, currentDepth);
        } else {
            traverse(current.left, currentDepth);
            traverse(current.right, currentDepth);
        }
        return currentDepth;
    }
    static class TreeNode {
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
    }
}
