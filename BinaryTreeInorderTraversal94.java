Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],

   1
    \
     2
    /
   3

return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while(root != null || !stack.isEmpty()){
            if (root == null){
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
            else{
                stack.push(root);
                root = root.left;
            }
        }
        return list;
    }
}
