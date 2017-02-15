
 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        //O(2^n)
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n <= 0 ) return res;
        List<Integer> list = new ArrayList<>();
        helper(k, n, res, list, 1);
        return res;
    }
    private void helper(int k, int n, List<List<Integer>> res, List<Integer> list, int pos){
        if (list.size() == k){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = pos; i <= n; i++){
            list.add(i);
            helper(k, n, res, list, i + 1);
            list.remove(list.size() - 1);
        }
        
    }
}
