Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 

public class Solution {
    public boolean isBalanced(TreeNode root) {
        int height = checkHeight(root);
        return height != -1;
    }
    private int checkHeight(TreeNode root){//O(N) N is number of nODES IN TREE
        if (root == null) return 0;
        int leftH = checkHeight(root.left);
        if (leftH == -1) return -1;
        int rightH = checkHeight(root.right);
        if (rightH == -1) return -1;
        if (Math.abs(leftH - rightH) > 1) return -1;
        return Math.max(leftH, rightH) + 1;
    }
}
