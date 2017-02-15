
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]


public class Solution {
    public List<String> generateParenthesis(int n) {//O(2^N);
    //remember: for backtracking or recursion, can use tree to check the idea of algorithm
        List<String> list = new ArrayList<String>();
        helper(n, n, list, "");
        return list;
    }
    private void helper(int left, int right, List<String> list, String str){
        if (left == 0 && right == 0){
            list.add(str);
            return;
        }
        if (left > 0){
            helper(left - 1, right, list, str + "(");
        }
        if (right > left){
            helper(left, right - 1, list, str + ")");
        }
    }
}
