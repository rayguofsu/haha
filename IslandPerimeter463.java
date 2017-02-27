You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:

public class Solution {
    public int islandPerimeter(int[][] grid) {
        //remember init 2D array:
        // int[][] grid =new int[n][m];
        /*int[][] multi = new int[][]{{50,60,55,67,70},{62,65,70,70,81},{72,66,77,80,69}};*/
        //can do bfs, but more easier solution here:
        //just check one by one; one 1 can contribute up to 4 based on values of neighbors.
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int sum = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){ //more like dfs
                    sum += helper(i, j - 1, grid);
                    sum += helper(i - 1, j, grid);
                    sum += helper(i + 1, j, grid);
                    sum += helper(i, j + 1, grid);
                }   
            }
        }
        return sum;
    }
    private int helper(int i, int j, int[][] grid){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return 1;
        else return 0;
    }
}
