 Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

public class Solution {
    public boolean exist(char[][] board, String word) {
                if (board == null || board.length == 0 || board[0].length == 0) return false;
        if (word == null || word.length() == 0) return true;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                    boolean res = dfs(board, i, j, word, 0, visited);
                    if (res) return res;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int row, int col, String word, int pos, boolean[][] visited){
        if (pos >= word.length()) return true;
        if (row <0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] == true) return false;
        if (board[row][col] == word.charAt(pos)){
        visited[row][col] = true;
            boolean res = dfs(board, row+1, col, word, pos+1, visited) || dfs(board,  row-1, col, word, pos + 1, visited) || dfs(board, row, col+1, word, pos + 1, visited) || dfs(board, row, col-1, word, pos + 1, visited);
        visited[row][col] = false;
        return res;
        }
        return false;
    }
}
