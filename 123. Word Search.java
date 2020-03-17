123. Word Search
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example
Example 1:

Input：["ABCE","SFCS","ADEE"]，"ABCCED"
Output：true
Explanation：
[    
     A B C E
     S F C S 
     A D E E
]
(0,0)A->(0,1)B->(0,2)C->(1,2)C->(2,2)E->(2,1)D
Example 2:

Input：["z"]，"z"
Output：true
Explanation：
[ z ]
(0,0)z

//recursion
public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (helper(word, 1, board, i, j, visited)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        
        return false;
    }
    
    private boolean helper(String word, int index, char[][] board, int row, int col, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        
        char c = word.charAt(index);
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        for (int i=0; i<4; i++) {
            int ptrx = row + x[i];
            int ptry = col + y[i];
            if (ptrx >= 0 && ptrx < board.length && ptry >= 0 && ptry < board[0].length && c == board[ptrx][ptry] && !visited[ptrx][ptry]) {
                visited[ptrx][ptry] = true;
                if (helper(word, index+1, board, ptrx, ptry, visited)) {
                    return true;
                }
                visited[ptrx][ptry] = false;
            }
        }
        
        return false;
    }
}