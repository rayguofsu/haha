
 Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6

The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

public class Solution {
    public void flatten(TreeNode root) {
        helper(root);
    }
    private TreeNode helper(TreeNode root){
        if (root == null) return null;
        //divide
        TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);
        //conquer
        if (leftLast != null){
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (rightLast != null) return rightLast;
        if (leftLast != null) return leftLast;
        return root;
        
     }
}
