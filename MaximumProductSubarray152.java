 Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6. 

public class Solution {
    public int maxProduct(int[] nums) {
        /*
Maximum Subarray那题的变种。由于正负得负，负负得正的关系。以A[i]结尾的max product subarray同时取决于以A[i-1]结尾的max / min product subarray以及A[i]本身。因此，对每个i，需要记录min/max product两个状态：
                     //each of the 3 is possible to be the candidates.
max_product[i] = max(max_product[i-1]*A[i], min_product[i-1]*A[i], A[i]) 
min_product[i] = min(max_product[i-1]*A[i], min_product[i-1]*A[i], A[i]) */

         if (nums == null || nums.length == 0) return 0;
         int maxDp = nums[0], minDp = nums[0], result = nums[0];
         for (int i = 1; i < nums.length; i++){//dp[i] ending with nums[i] depends on 3 items.
             int maxCopy = maxDp;
             maxDp = Math.max(maxDp * nums[i], Math.max(nums[i], nums[i] * minDp));
             minDp = Math.min(minDp * nums[i], Math.min(nums[i], nums[i] * maxCopy));
             result = Math.max(maxDp, result);
         }
         return result;
        
    }
}
