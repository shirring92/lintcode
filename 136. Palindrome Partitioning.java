136. Palindrome Partitioning
Given a string s. Partition s such that every substring in the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example
Example 1:

Input: "a"
Output: [["a"]]
Explanation: Only 1 char in the string, only 1 way to split it (itself).
Example 2:

Input: "aab"
Output: [["aa", "b"], ["a", "a", "b"]]
Explanation: There are 2 ways to split "aab".
    1. Split "aab" into "aa" and "b", both palindrome.
    2. Split "aab" into "a", "a", and "b", all palindrome.
Notice
Different partitionings can be in any order.
Each substring must be a continuous segment of s.

//recursion。 O(n*(2^n))
public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        
        helper(s, 0, new ArrayList<String>(), ans);
        
        return ans;
    }
    
    private void helper(String s, int index, List<String> list, List<List<String>> ans) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for (int i=index; i<s.length(); i++) {
            if (ispalindrome(s.substring(index, i+1))) {
                list.add(s.substring(index, i+1));
                helper(s, i+1, list, ans);
                list.remove(list.size()-1);
            }
        }
    }
    
    private boolean ispalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }
            else {
                return false;
            }
        }
        
        return true;
    }
}

//DP. O(n^2 + 2^n) = O(2^n)
public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        
        boolean[][] visited = palindrome(s);
        helper(s, 0, new ArrayList<String>(), ans, visited);
        
        return ans;
    }
    
    private void helper(String s, int index, List<String> list, List<List<String>> ans, boolean[][] visited) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for (int i=index; i<s.length(); i++) {
            if (visited[index][i]) {
                list.add(s.substring(index, i+1));
                helper(s, i+1, list, ans, visited);
                list.remove(list.size()-1);
            }
        }
    }
    
    private boolean[][] palindrome(String s) {
        boolean[][] ans = new boolean[s.length()][s.length()];
        for (int i=0; i<s.length(); i++) {
            ans[i][i] = true;
            int j = 1;
            while (i + j < s.length() && i - j >= 0) {
                if (ans[i-j+1][i+j-1] && s.charAt(i-j) == s.charAt(i+j)) {
                    ans[i-j][i+j] = true;
                    j++;
                }
                else {
                    break;
                }
            }
        }
        
        for (int i=0; i<s.length()-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                ans[i][i+1] = true;
            }
            int j = 1;
            while (i + 1 + j <s.length() && i - j >= 0) {
                if (ans[i-j+1][i+j] && s.charAt(i-j) == s.charAt(i+1+j)) {
                    ans[i-j][i+1+j] = true;
                    j++;
                }
                else {
                    break;
                }
            }
        }
        
        return ans;
    }
}