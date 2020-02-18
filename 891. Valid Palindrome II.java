891. Valid Palindrome II
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example
Example 1:

Input: s = "aba"
Output: true
Explanation: Originally a palindrome.
Example 2:

Input: s = "abca"
Output: true
Explanation: Delete 'b' or 'c'.
Example 3:

Input: s = "abc"
Output: false
Explanation: Deleting any letter can not make it a palindrome.
Notice
The string will only contain lowercase characters.
The maximum length of the string is 50000.

public class Solution {
    /**
     * @param s: a string
     * @return boolean: whether you can make s a palindrome by deleting at most one character
     */
    public boolean validPalindrome(String s) {
        // Write your code here
        int left = 0;
        int right = s.length()-1;
        boolean ans = true;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                ans = helper(s, left+1, right) || helper(s, left, right-1);
                break;
            }
            left++;
            right--;
        }
        
        return ans;
    }
    
    private boolean helper(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}