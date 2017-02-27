Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless. 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return null;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            TreeNode node = que.poll();
            if (node != null){
                sb.append(node.val + " ");//remember String.valueOf(int) return string; Integer.valueOf(string) return Integer
                que.offer(node.left);
                que.offer(node.right);
            }
            else{
                sb.append("n ");
            }
        }
       // System.out.println("node is " + sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] strs = data.split(" ");
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
        que.offer(root);
        //System.out.println("str is " + strs[0]);
        for (int i = 1; i < strs.length; i++){   
            //System.out.println("str is " + strs[i]);
            TreeNode node = que.poll();
            if (!strs[i].equals("n")){   //remember for string use equals
                node.left = new TreeNode(Integer.valueOf(strs[i]));
                que.offer(node.left);
            }
            if (!strs[++i].equals("n")){
                node.right = new TreeNode(Integer.valueOf(strs[i]));
                que.offer(node.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
