A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

public class Solution {
    public int uniquePaths(int m, int n) {
        //DP: state[i, j] = state[i - 1, j] + state[i, j - 1];
        int[] row = new int[n];
        
        Arrays.fill(row, 1);
        
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                row[j] += row[j - 1];
            }
        }
        return row[n - 1];
    }
}
