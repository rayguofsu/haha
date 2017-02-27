 Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9. 

public class Solution {
    public int numSquares(int n) {
        //dp[i] = Min(dp[j]) + 1 (i - j is an square number)(dp[i] is the min number of perfect sq numbers to form i)
        if (n < 1) return -1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[0] = 0;
        for(int i = 2; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++){//has == here is for i = 25, 36, .. perfect sq number; dp[i] = 1;
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
