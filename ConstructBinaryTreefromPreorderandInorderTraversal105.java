



Given preorder and inorder traversal of a tree, construct the binary tree.


public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        if (preStart > preEnd || inStart > inEnd) return null;
        //System.out.println(" preStart is " + preStart + " preeND Is " + preEnd);
        TreeNode root = new TreeNode(preorder[preStart]);
        int i = inStart;
        for (i = inStart; i <= inEnd; i++){
            if (inorder[i] == preorder[preStart]) break;
        }
        root.left = helper(preorder, inorder, preStart + 1, preStart + i - inStart, inStart, i - 1);
        root.right = helper(preorder, inorder, preStart + i - inStart + 1, preEnd, i + 1, inEnd);
        return root;
        
    }
}
