 Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5

All root-to-leaf paths are:

["1->2->5", "1->3"]

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        dfs(res, root, "");
        return res;
    }
    private void dfs(List<String> res, TreeNode root, String path){
        if (root == null) return;
        path += Integer.valueOf(root.val); //remember 
        if (root.left == null && root.right == null){
            res.add(path);
            return;
        }
        dfs(res, root.left, path + "->");
        dfs(res, root.right, path + "->");
    }
}
