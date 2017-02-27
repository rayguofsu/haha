Given inorder and postorder traversal of a tree, construct the binary tree.

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null) return null;
        return helper(postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }
    private TreeNode helper(int[] postorder, int[] inorder, int postStart, int postEnd, int inStart, int inEnd){
        if (postStart > postEnd || inStart > inEnd) return null;
        //System.out.println(" preStart is " + preStart + " preeND Is " + preEnd);
        TreeNode root = new TreeNode(postorder[postEnd]);
        int i = inStart;
        for (i = inStart; i <= inEnd; i++){
            if (inorder[i] == postorder[postEnd]) break;
        }
        root.left = helper(postorder, inorder, postStart, postStart + i - inStart - 1, inStart, i - 1);
        root.right = helper(postorder, inorder, postStart + i - inStart, postEnd - 1, i + 1, inEnd);
        return root;
        
        
    }
}
