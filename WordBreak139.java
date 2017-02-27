 Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code". 

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return true;
        //dp[i] = OR(dp[j])
        //O(LN); N is s.length(); L is max length of word in wordDict
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        int maxLen = 0;
        for (String str: wordDict){
            maxLen = Math.max(str.length(), maxLen);
        }
        for (int i = 1; i <= n; i++){
            dp[i] = false;
            for (int j = 1; j <= maxLen && j <= i; j++){
                if (dp[i - j] && wordDict.contains(s.substring(i - j, i))){
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}
