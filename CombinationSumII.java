 Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
A solution set is:

[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        subsetsBuild(res, list, candidates, 0, target);
        return res;
    }
    
    private void subsetsBuild(List<List<Integer>> res, List<Integer> list, int[] nums, int pos, int remainSum){
        if (remainSum < 0) return;
        if (remainSum == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = pos; i < nums.length; i++){
            if (i != pos && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            subsetsBuild(res, list, nums, i + 1, remainSum - nums[i]);
            list.remove(list.size() - 1);
        }
    }
}
