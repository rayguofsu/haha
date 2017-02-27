Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int countNodes(TreeNode root) {//O(2^N) N is height
        if (root == null) return 0;
        int leftH = countLeft(root.left);
        int rightH = countRight(root.right);
        if (leftH == rightH){
            return (2 << leftH) - 1;
        }
        else{
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
    private int countLeft(TreeNode root){
        int h = 0;
        while(root != null){
            root = root.left;
            h++;
        }
        return h;
    }
    
    
    private int countRight(TreeNode root){
        int h = 0;
        while(root != null){
            root = root.right;
            h++;
        }
        return h;
    }
}
