 Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity? 

public class Solution {
    /*public int lengthOfLIS(int[] nums) {
        //O(n^2)
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }*/
    public int lengthOfLIS(int[] nums) {
    //O(nlogn): log(N!) = log1 + log2 + ..logN = Nlog(N) online has prove of this in some pdf
        if (nums == null || nums.length == 0)return 0;
        List<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > list.get(list.size() - 1)){
                list.add(nums[i]);
            }
            else{
                helper(nums[i], list);
            }
        }
        return list.size();
    
        
    }
    private void helper(int target, List<Integer> list){
        //finding the first one larger than target ; starting scan from left
        int lo = 0;
        int hi = list.size() - 1;
        int res = 0;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int num = list.get(mid);
            if (num < target){
                lo = mid + 1;
            }
            else{
                res = mid;
                hi = mid - 1;
            }

        }
        list.set(res, target);
    }
}
