132. Word Search II
Given a matrix of lower alphabets and a dictionary. Find all words in the dictionary that can be found in the matrix. A word can start from any position in the matrix and go left/right/up/down to the adjacent position. One character only be used once in one word. No same word in dictionary

Example
Example 1:

Input：["doaf","agai","dcan"]，["dog","dad","dgdg","can","again"]
Output：["again","can","dad","dog"]
Explanation：
  d o a f
  a g a i
  d c a n
search in Matrix，so return ["again","can","dad","dog"].
Example 2:

Input：["a"]，["b"]
Output：[]
Explanation：
 a
search in Matrix，return [].
Challenge
Using trie to implement your algorithm.

//
public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        List<String> ans = new ArrayList<>();
        
        for (String word: words) {
            
            boolean[][] visited = new boolean[board.length][board[0].length];
            findword:
            for (int i=0; i<board.length; i++) {
                for (int j=0; j<board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        visited[i][j] = true;
                        if (helper(word, 1, board, i, j, visited)) {
                            ans.add(word);
                            break findword;
                        }
                        visited[i][j] = false;
                    }
                }
            }
        }
        
        return ans;
    }
    
    private boolean helper(String word, int index, char[][] board, int row, int col, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        char c = word.charAt(index);
        for (int i=0; i<4; i++) {
            int ptrx = row + x[i];
            int ptry = col + y[i];
            if (ptrx >= 0 && ptrx < board.length && ptry >= 0 && ptry < board[0].length && board[ptrx][ptry] == c && !visited[ptrx][ptry]) {
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