 A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2. 

public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++){
            //remember
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            //System.out.println("two digit is " + twoDigit);
            if (oneDigit != 0){
                dp[i] += dp[i - 1];
            }
            if (twoDigit >= 10 && twoDigit <= 26){
            //    System.out.println("two");
                dp[i] += dp[i - 2];
            }

        }
        return dp[len];
    }
}
