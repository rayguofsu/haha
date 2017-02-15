
 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:

[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        /*Remember List<Integer> intList = new ArrayList<Integer>();
intList.add(1);
intList.add(2);
intList.add(3);


String listString = intList.toString();
System.out.println(listString); //<- this prints [1, 2, 3]

If you don't want [] in the string, simply use the substring e.g.:

   listString = listString.substring(1, listString.length()-1); 
   System.out.println(listString); //<- this prints 1, 2, 3*/
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        helper(res, list, nums, visited);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int[] visited){
        if (list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0 || visited[i] == 1) continue;
            list.add(nums[i]);
            visited[i] = 1;
            helper(res, list, nums, visited);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }

    }
}
