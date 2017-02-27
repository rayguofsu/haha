 A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list. 

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode headCp = head;
        while(head != null){
            map.put(head, new RandomListNode(head.label));
            head = head.next;
        }
        for (RandomListNode node: map.keySet()){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
        }
        return map.get(headCp);
    }
}
