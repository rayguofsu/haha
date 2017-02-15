 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6. 

public class Solution {
    public int maxSubArray(int[] nums) {
        //version 2: using prefix sum for array problem.
        if (nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE, min = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
        }
        return max;
    }
/*    // Version 1: Greedy

public class Solution {
    public int maxSubArray(int[] A) {
       int maxSum = Integer.MIN_VALUE;
       int sum = 0;
       for (int i = 0; i < nums.length; i++){
          sum += nums[i];  //do not reset sum here; as what if all negative; doing this way will
          //garantuee that maxSum is the max
          if (sum > maxSum){
             maxSum = sum;
          }
          if (sum < 0){
             sum = 0;  //reset sum is negative;
          }
       }
    }
}*/
}
