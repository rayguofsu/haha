Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

public class Solution {
    public int lengthOfLongestSubstring(String s) {//two pointer+hashMap
        //this is so tricky; different idea easy to get wrong ans; just remeber it.
        //j always point at the non duplicate substring first position
        if (s == null || s.length() == 0) return 0;
        Set<Character> map = new HashSet<>();
        int j = 0;
        char[] c = s.toCharArray();
        int res = 0;
        for (int i = 0; i < s.length(); i++){
            if (map.contains(c[i])){
                while(c[j] != c[i]){
                    map.remove(c[j++]);
                }
                map.remove(c[j++]);  //for cases where the first c[j] == c[i]; e.g. p q p; the while loop will not execute
            }
            //else is wrong
            map.add(c[i]);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
