
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:

Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

Note:

    You may assume that the array does not change.
    There are many calls to sumRange function.

public class NumArray {
    //remeber for array, use prefix sum
    int[] dpSum;
    //trick dp[2] = dp[0] + dp[1];    
    public NumArray(int[] nums) {
        if (nums == null) return;
        int n = nums.length;
        dpSum = new int[n + 1];
        int sum = 0;
        for (int i = 1; i <= n; i++){
            sum += nums[i - 1];
            dpSum[i] = sum;
        }
    }
    
    public int sumRange(int i, int j) {
        return dpSum[j + 1] - dpSum[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);*/
