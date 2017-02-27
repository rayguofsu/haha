
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if (root == null) return 0;
        //divide
        int leftSum = sumOfLeftLeaves(root.left);
        int rightSum = sumOfLeftLeaves(root.right);
        //conquer
        if (root.left != null){
            if (root.left.left == null && root.left.right == null){
                res += root.left.val;
            }
        }
        return leftSum + rightSum + res;
    }
    
}
