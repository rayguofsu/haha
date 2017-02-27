
 Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Return 4. 
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] maxSqre = new int[m][n];
        int maxArea = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 || j == 0){
                    maxSqre[i][j] = matrix[i][j] - '0';
                }
                else if (matrix[i][j] == '1'){
                  //  int min = Math.min(Character.getNumericValue(matrix[i][j - 1]), Character.getNumericValue(matrix[i - 1][j]));
                    int min = Math.min(maxSqre[i][j - 1], maxSqre[i - 1][j]);
                    min = Math.min(min, maxSqre[i - 1][j - 1]) + 1;
                    maxSqre[i][j] = min;
                }
                maxArea = Math.max(maxArea, maxSqre[i][j] * maxSqre[i][j]);
            }
        }
        return maxArea;
    }
}
