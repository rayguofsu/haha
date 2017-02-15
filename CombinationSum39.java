 Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:

[
  [7],
  [2, 2, 3]
]
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    /*remember This algorithm has time complexity O((n+k)!) where n is the size of candidates, and k is the max repeated times for each candidates
space complexity O(m) where target/smallest element from candidates.*/
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        helper(target, res, list, candidates, 0);
        return res;
    }
    private void helper(int remainSum, List<List<Integer>> res, List<Integer> list, int[] candidates, int start){
        if (remainSum < 0) return;
        if (remainSum == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++){
            list.add(candidates[i]);
            helper(remainSum - candidates[i], res, list, candidates, i);
            list.remove(list.size() - 1);
        }
    }
}
