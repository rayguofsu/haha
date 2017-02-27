Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        List<String> list = new ArrayList<>();
        helper(res, list, s, 0);
        return res;
    }
    private void helper(List<List<String>> res, List<String> list, String s, int start){
        if (start == s.length()){
            res.add(new ArrayList<String>(list));
            return;
        }
        for (int i = start + 1; i <= s.length(); i++){
            String sub =s.substring(start, i);
            if (validPalindrom(sub)){
                list.add(sub);
                helper(res, list, s, i);
                list.remove(list.size() - 1);
            }
        }
    }
    private boolean validPalindrom(String s){
        if (s == null || s.length() == 0) return true;
        int lo = 0, hi = s.length() - 1;
        while(lo < hi){
            if (s.charAt(lo) != s.charAt(hi)){
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
