 Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"

Output:

4

One possible longest palindromic subsequence is "bbbb".

Example 2:
Input:

"cbbd"

Output:

2

One possible longest palindromic subsequence is "bb". 

public class Solution {
    public int longestPalindromeSubseq(String s) {
        //dp[i][j] = max len of palindrom inside substring[i, j] inclusive
        //dp[i][j] = dp[i+1][j-1] + 2 if [i]==[j]
        //         or = max(dp[i + 1][j], dp[i][j - 1])
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i = 0;i < len;i++){
            dp[i][i] = 1;
        }
        for (int l = 2; l <= len; l++){
            for (int start = 0; start <= len - l; start++){
                int end = start + l - 1;
                if (s.charAt(end) == s.charAt(start)){
                    dp[start][end] = dp[start + 1][end - 1] + 2;
                }
                else{
                    dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
