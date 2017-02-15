
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

public class Solution {
    //remember jiuzhang said "tree" think about divide and conquer
    //also he said dp can solve how many ways to do it, but do not care what is the way, such as 
    //Unique Binary Search Trees I
    
    //divid and conquer is used below; time O(2^n); space(2^n) space is not O(n) as it divide each recursion to two
    public List<TreeNode> generateTrees(int n) {
        
        List<TreeNode> list = new ArrayList<>();
        if (n <= 0) return list;
        list = helper(1, n);
        return list;
    }
    
    private List<TreeNode> helper(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        if (start > end){
            list.add(null);
        }
        for (int i = start; i <= end; i++){
            //divide
            List<TreeNode> left = helper(start, i - 1);
            List<TreeNode> right = helper(i + 1, end);
            //conquer
            for (TreeNode leftNode : left){
                for (TreeNode rightNode : right){
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    list.add(root);
                }
            }
        }
        return list;
        
    }
}
