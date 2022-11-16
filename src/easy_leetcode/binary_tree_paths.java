package easy_leetcode;

import java.util.ArrayList;
import java.util.List;

public class binary_tree_paths {

    /**
     *           3
     *         /   \
     *        20    9
     *       /  \
     *      15   7
     */
    static List<String> global = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode secondLayerRight = new TreeNode(7, null, null);
        TreeNode secondLayerLeft = new TreeNode(15, null, null);
        TreeNode firstLayerLeft = new TreeNode(20, secondLayerLeft, secondLayerRight);
        TreeNode firstLayerRight = new TreeNode(9, null, null);
        TreeNode root = new TreeNode(3, firstLayerLeft, firstLayerRight);

        binaryTreePaths(root);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        traverse(root, "");
        System.out.println(global);
        return global;
    }

    public static void traverse(TreeNode currentNode, String currentPath) {
        currentPath = currentPath + currentNode.val + "->";

        if(currentNode.left == null && currentNode.right == null) {
            global.add(currentPath.substring(0, currentPath.length() - 2));
        } else if (currentNode.left == null) {
            traverse(currentNode.right, currentPath);
        } else if (currentNode.right == null) {
            traverse(currentNode.left, currentPath);
        } else {
            traverse(currentNode.left, currentPath);
            traverse(currentNode.right, currentPath);
        }
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
