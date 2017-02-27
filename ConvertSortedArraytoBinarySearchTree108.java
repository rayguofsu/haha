Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }
    private TreeNode helper(int[] nums, int start, int end){
        if (start > end) return null;
        int mid = start + (end -start) / 2;
        TreeNode newRoot = new TreeNode(nums[mid]);
        newRoot.left = helper(nums, start, mid - 1);
        newRoot.right = helper(nums, mid + 1, end);
        return newRoot;
    }
}
