
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res= new ArrayList<>();
        if (s.length() < p.length()) return res;
        int[] window = new int[256];
        char[] pc = p.toCharArray();
        char[] sc = s.toCharArray();
        int pLen = pc.length;
        for (int i = 0; i < pLen; i++){
            window[pc[i]]++;
            window[sc[i]]--;
        }
        if (check(window)) res.add(0);
        for (int i = pLen; i < sc.length; i++){
            window[sc[i - pLen]]++;
            window[sc[i]]--;
            if (check(window)){
                res.add(i - pc.length + 1);
            }
            
        }
        return res;
    }
    private boolean check(int[] win){
        for (int i = 0; i < win.length; i++){
            if (win[i] != 0) return false;
        }
        return true;
    }
}
