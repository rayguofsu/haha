Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]


Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        subsetsBuild(res, list, 1, k, n);
        return res;
    }
    
    private void subsetsBuild(List<List<Integer>> res, List<Integer> list, int pos, int k, int remainSum){
        if (remainSum < 0) return;
        if (remainSum == 0){
            if (list.size() == k){
                res.add(new ArrayList<Integer>(list));
            }
            return;
        }
        
        for (int i = pos; i <= 9; i++){
            list.add(i);
            subsetsBuild(res, list, i + 1, k, remainSum - i);
            list.remove(list.size() - 1);
        }
    }
}
