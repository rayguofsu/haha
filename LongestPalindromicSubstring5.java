Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.

Example:

Input: "cbbd"

Output: "bb"
public class Solution {
    public String longestPalindrome(String s) {
        // remember two cases, i == i + 1 and i == i + 2; expand both parallelly to get both even and odd string
        if (s == null || s.length() == 0) return "";
        String res = s.charAt(0) + "";
        for (int i = 1; i < s.length(); i++){//O(N^2);
            char c1 = s.charAt(i);
            char c2 = s.charAt(i - 1);
            if (c1 == c2){
                String newStr = strExpand(s, i - 1, i);
                res = newStr.length() > res.length() ? newStr : res;
            }
            //Remember else: cannot have else here
            if (i > 1 && c1 == s.charAt(i - 2)){
                String newStr = strExpand(s, i - 2, i);
                res = newStr.length() > res.length() ? newStr : res;
            }
            
        }
        return res;
    }
    private String strExpand(String s, int left, int right){
        while(left >= 0 && right < s.length()){
            if (s.charAt(left) != s.charAt(right)){
                break;
            }
            else{
                left--;
                right++;
            }
        }
        return s.substring(left + 1, right);
    }
}
