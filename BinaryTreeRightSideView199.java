public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        //using BFS
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            TreeNode node = null;
            for (int i = 0; i < size; i++){
                node = que.poll();
                if (node.left != null){
                    que.offer(node.left);
                }
                if (node.right != null){
                    que.offer(node.right);
                }
            }
            res.add(node.val);
        }
        return res;
    }
}
