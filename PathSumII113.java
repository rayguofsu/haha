 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1

return

[
   [5,4,11,2],
   [5,8,4,5]
]

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(root, sum, res, list);
        return res;
    }
    
    
    private void helper(TreeNode root, int remainSum, List<List<Integer>> res, List<Integer> list){
        if (root == null) return;
        if (root.left == null && root.right == null){
            if (root.val == remainSum){
                List<Integer> newList = new ArrayList<>(list);
                newList.add(root.val);
                res.add(newList);
            }
            return;
        }
        list.add(root.val);
        helper(root.left, remainSum - root.val, res, list);
        helper(root.right, remainSum - root.val, res, list);
        list.remove(list.size() - 1);
        
    }
    
}
