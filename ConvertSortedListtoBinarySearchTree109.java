Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode newRoot = new TreeNode(slow.val);
        prev.next = null;
        newRoot.left = sortedListToBST(head);
        newRoot.right = sortedListToBST(slow.next);
        return newRoot;
    }
}
