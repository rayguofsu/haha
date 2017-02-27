Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int even = 0, odd = 0;
        for (int i = 0; i < nums.length - 1; i++){
            if (i % 2 == 0){
                even = Math.max(even + nums[i], odd);
            }
            else{
                odd = Math.max(odd + nums[i], even);
            }
        }
        int max1 = Math.max(even, odd);
        
        even = 0; odd = 0;
        for (int i = 1; i < nums.length; i++){
            if (i % 2 == 0){
                even = Math.max(even + nums[i], odd);
            }
            else{
                odd = Math.max(odd + nums[i], even);
            }
        }
        return Math.max(Math.max(even, odd), max1);
        
        
    
        
    }
}
