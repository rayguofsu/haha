
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //remember for changing order question, can use two stacks; like this and que using stacks
        Stack<TreeNode> toRight = new Stack<>();
        Stack<TreeNode> toLeft = new Stack<>();      
        if (root != null){
            toRight.add(root);
        }
        List<List<Integer>> res = new ArrayList<>();
        while(!toRight.isEmpty() || !toLeft.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int rightSize = toRight.size();
            for (int i = 0; i < rightSize; i++){
                TreeNode node = toRight.pop();
                list.add(node.val);
                if (node.left != null){
                    System.out.println("added " + node.left.val);
                    toLeft.add(node.left);
                }
                if (node.right != null){
                    toLeft.add(node.right);
                    System.out.println("added " + node.right.val);
                }
            }
            if (list.size() > 0) res.add(new ArrayList<Integer>(list));
            list.clear();//remember
            int leftSize = toLeft.size();
            for (int i = 0; i < leftSize; i++){
                
                TreeNode node = toLeft.pop();
                list.add(node.val);
                if (node.right != null){
                    toRight.add(node.right);
                }
                if (node.left != null){
                    toRight.add(node.left);
                }
            }
            if (list.size() > 0) res.add(new ArrayList<Integer>(list));
            
        }
        return res;
        
        
        
    }
}
