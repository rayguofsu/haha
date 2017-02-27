Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

public class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] c = s.toCharArray();
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < c.length; i++){
            freqMap.put(c[i], freqMap.getOrDefault(c[i], 0) + 1);
        }
        int res = 0;
        int one = 0;
        //remember for (Character tmp : freqMap.keySet()){
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()){
            int v = entry.getValue();
            res += v / 2 * 2;
            if (v % 2 == 1) one = 1;
        }

        return res + one;
    }
}
