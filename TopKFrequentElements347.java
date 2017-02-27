
 Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note:

    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //Remember using PriorityQueue
        //Remember map.entrySet()
        PriorityQueue<Map.Entry<Integer, Integer>> que = new PriorityQueue<Map.Entry<Integer, Integer>>(new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2){
                return e1.getValue() - e2.getValue();
            }
        });
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()){//O(k log k)
            if (que.size() < k){
                que.offer(entry);
            }
            else{
                if (que.peek().getValue() < entry.getValue()){
                    que.poll();
                    que.offer(entry);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : que){
            list.add(e.getKey());
        }
        return list;
    }
}
