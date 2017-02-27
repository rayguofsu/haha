Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. 

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        /*remeber to initialize List<List<Integer>> list = asList(
                             asList(1,2,3),
                             asList(4,5,6),
                              asList(7,8,9),
                           );*/
        if (triangle == null || triangle.size() == 0) return 0;
        List<Integer> prev = triangle.get(0);
        for (int j = 1; j < triangle.size(); j++){
            List<Integer> cur = triangle.get(j);
            int curSize = cur.size();
            for (int i = 0; i < curSize - 1; i++){
                if (i == 0){
                    cur.set(i, cur.get(i) + prev.get(i));
                }
                else{
                    cur.set(i, cur.get(i) + Math.min(prev.get(i - 1), prev.get(i)));
                }
            }
            cur.set(curSize - 1, cur.get(curSize - 1) + prev.get(prev.size() - 1));
            prev = cur;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prev.size(); i++){
            min = Math.min(min, prev.get(i));
        }
        return min;
    }
}
