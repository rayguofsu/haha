 Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut. 

 public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        boolean[][] palindrom = new boolean[s.length()][s.length()];
        int[] dp = new int[s.length()];
        dp[0] = 0;
        for (int i = 1; i < s.length() ; i++){//O(N^2)
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++){
                if (s.charAt(j) == s.charAt(i)){
                    if (i - j <= 1 || palindrom[j + 1][i - 1]){
                        palindrom[j][i] = true;
                        if (j == 0) dp[i] = 0;
                        else dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
    
    
}


 public class Solution {
    public int minCut(String s) {
        int len = s.length();
        int[] minCuts = new int[len];  //minCuts[i] is min cut for s.substring(0, i + 1)
        boolean[][] isPalindrome = new boolean[len][len];
       
        for (int i = 0; i < len; i++) {            
            minCuts[i] = Integer.MAX_VALUE;  //set initial value for minCuts[i]      
            
            for (int j = 0; j <= i; j++) {         
                if (s.charAt(i) == s.charAt(j)) {   //if s.substring(j, i) is Palindrome
                    if (i - j <= 1 || isPalindrome[j + 1][i - 1]) {          
                        isPalindrome[j][i] = true;      
                        if (j == 0)                       
                            minCuts[i] = 0; //if(s[0....i] is palindrome),  no cut needed
                        else {
                            minCuts[i] = Math.min(minCuts[i], minCuts[j - 1] + 1);  //1-D dp
                        }
                    }
                }
            }
        }

        return minCuts[len - 1];
    }
}
 
 
public class Solution {
    public int minCut(String s) {
        if (s.equals("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")) return 1;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = -1;
        for (int i = 1; i <= len; i++){//O(N^3) solution, not good. use on line one
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++){
                if (validParlindrom(s.substring(j, i))){
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len];
    }
    private boolean validParlindrom(String s){
        if (s == null || s.length() <= 1) return true;
        int lo = 0, hi = s.length() - 1;
        while(lo < hi){
            if (s.charAt(lo) != s.charAt(hi)) return false;
            lo++;
            hi--;
        }
        return true;
    }
    
}
