
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

    Search for a node to remove.
    If the node is found, delete the node.

Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {//hard to remember
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode parent = find(dummy, root, key);
        TreeNode node = null;
        if (parent.left != null && parent.left.val == key){
            node = parent.left;
        }
        if (parent.right != null && parent.right.val == key){
            node = parent.right;
        }
        delete(parent, node);
        
        return dummy.left;
    }
    private TreeNode find(TreeNode parent, TreeNode root, int key){
        while(root != null){
            if (root.val < key){
                parent = root;
                root = root.right;
            }
            else if (root.val > key){
                parent = root;
                root = root.left;
            }
            else{
                break;
            }
        }
        return parent;
    }
    private void delete(TreeNode parent, TreeNode node){
        if (parent == null || node == null) return;
        if (node.right == null){
            if (parent.left == node){
                parent.left = node.left;
            }
            else if (parent.right == node){
                parent.right = node.left;
            }
            return;
        }
        //
        if (parent.left == node){
            parent.left = node.right;
        }
        else if (parent.right == node){
            parent.right = node.right;
        }
        TreeNode leftCp = node.left;
        node = node.right;
        while(node.left != null){
            node = node.left;
        }
        node.left = leftCp;
    }
}
