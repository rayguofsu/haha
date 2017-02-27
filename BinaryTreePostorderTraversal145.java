Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
                List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            if (root == null){
                root = stack.pop();
            }
            list.add(0, root.val);
            if (root.left != null){
                stack.push(root.left);
            }
            root = root.right;
        }
        return list;
    }
}
