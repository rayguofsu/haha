Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]

Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]

Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                max = Math.max(max, dfs(matrix, dp, i, j, Integer.MIN_VALUE));
            }
        }
        return max;
    }
    private int dfs(int[][] matrix, int[][] dp, int row, int col, int prev){
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || matrix[row][col] <= prev){
            return 0;
        }
        if (dp[row][col] > 0) return dp[row][col];
        int left = dfs(matrix, dp, row - 1, col, matrix[row][col]);
        int right = dfs(matrix, dp, row + 1, col, matrix[row][col]);
        int up =dfs(matrix, dp, row, col - 1, matrix[row][col]);
        int dn =dfs(matrix, dp, row, col + 1, matrix[row][col]);
        dp[row][col] = Math.max(right, left);
        dp[row][col] = Math.max(dp[row][col], Math.max(up, dn)) + 1;
        return dp[row][col];
    }
}
