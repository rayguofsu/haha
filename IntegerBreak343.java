 Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: You may assume that n is not less than 2 and not larger than 58. 

public class Solution {
    public int integerBreak(int n) {
        if (n <= 1) return 1;
        //dp[i] = Math.max(dp[j] * (i - j))(but should add j * (i - j) also)
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            for (int j = 1; j < i; j++){        //Remember during cracking, try to use more e.g.  such as for 4 = 2*2; not covered by dp[j] * (i - j)
                dp[i] = Math.max(dp[i], Math.max(dp[j] * (i - j), j * (i - j)));
            }
        }
        return dp[n];
    }
}
