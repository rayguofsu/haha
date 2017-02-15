Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

public class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 1; i < grid[0].length; i++){
            grid[0][i] += grid[0][i-1];
        }
        for (int i = 1; i < grid.length; i++){
            grid[i][0] += grid[i-1][0];
        }
     for (int row = 1; row < grid.length; row++){
           for (int column = 1; column < grid[0].length; column++){
               grid[row][column] += Math.min(grid[row][column - 1], grid[row - 1][column]);
           }
       }
        /*for (int i = 1; i < grid[0].length; i++){
            for (int j = 1; j < grid.length; j++){
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        */
        return grid[n-1][m-1];
    }
}
