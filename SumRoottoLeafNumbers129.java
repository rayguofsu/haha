Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3

The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25. 

public class Solution {
    public int sumNumbers(TreeNode root) {
        int[] sum = new int[1];
        helper(root, sum, 0);
        return sum[0];
    }
    private void helper(TreeNode root, int[] sum, int digits){
        if (root == null) return;
        digits = digits * 10 + root.val;
        if (root.left == null && root.right == null){
            sum[0] += digits;
            return;
        }
        helper(root.left, sum, digits);
        helper(root.right, sum, digits);
    }
}
