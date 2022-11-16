package easy_leetcode;

public class binary_tree_same {

    /**
     * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
     * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
     */

    public static void main(String[] args) {
        TreeNode secondLayerRight = new TreeNode(7, null, null);
        TreeNode secondLayerLeft = new TreeNode(15, null, null);
        TreeNode firstLayerLeft = new TreeNode(20, secondLayerLeft, secondLayerRight);
        TreeNode firstLayerRight = new TreeNode(9, null, null);
        TreeNode root = new TreeNode(3, firstLayerLeft, firstLayerRight);


        TreeNode secondLayerRight2 = new TreeNode(7, null, null);
        TreeNode secondLayerLeft2 = new TreeNode(15, null, null);
        TreeNode firstLayerLeft2 = new TreeNode(20, secondLayerLeft2, secondLayerRight2);
        TreeNode firstLayerRight2 = new TreeNode(9, null, null);
        TreeNode root2 = new TreeNode(3, firstLayerLeft2, firstLayerRight2);
        System.out.println(isSameTree(root, root2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        return traverse(p, q);
    }

    public static boolean traverse(TreeNode firstCurrentNode, TreeNode secondCurrentNode) {
        boolean symmetrical = true;
        if(firstCurrentNode != null && secondCurrentNode != null) {
            if (firstCurrentNode.val != secondCurrentNode.val) {
                return false;
            } else if (firstCurrentNode.left != null && secondCurrentNode.left == null) {
                return false;
            } else if (firstCurrentNode.left == null && secondCurrentNode.left != null) {
                return false;
            } else if (firstCurrentNode.right != null && secondCurrentNode.right == null) {
                return false;
            } else if (firstCurrentNode.right == null && secondCurrentNode.right != null) {
                return false;
            }
            symmetrical = traverse(firstCurrentNode.left, secondCurrentNode.left);
            if(!symmetrical) {
                return false;
            }
            symmetrical = traverse(firstCurrentNode.right, secondCurrentNode.right);
        } else if(firstCurrentNode == null && secondCurrentNode != null) {
            symmetrical = false;
        } else if(secondCurrentNode == null && firstCurrentNode != null) {
            symmetrical = false;
        }
        return symmetrical;
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
