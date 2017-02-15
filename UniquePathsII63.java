Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,

There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]

The total number of unique paths is 2.

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //DP: state[i, j] = state[i - 1, j] + state[i, j - 1];
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int n = obstacleGrid[0].length;
        int m = obstacleGrid.length;

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 && j == 0){
                    obstacleGrid[i][j] ^= 1;
                    continue;
                }
                if (obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                if (i == 0 && j > 0){
                    obstacleGrid[i][j] += obstacleGrid[i][j - 1];
                }
                else if (j == 0 && i > 0){
                    obstacleGrid[i][j] += obstacleGrid[i - 1][j];
                }
                else if (i > 0 && j > 0){
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }
    /* using O(n) space solution:
            int col = obstacleGrid[0].length;
        int row = obstacleGrid.length;
        int[] dp = new int[col];
        dp[0] = 1;
        for (int i = 0; i <row; i++){
            for (int j = 0; j < col; j++){
                if (obstacleGrid[i][j] == 1) dp[j] = 0;
                else if (j >0)
                    dp[j] += dp[j-1];
            }
        }
        return dp[col-1];
        */
}
