415. Valid Palindrome
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example
Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama"
Example 2:

Input: "race a car"
Output: false
Explanation: "raceacar"
Challenge
O(n) time without extra memory.

Notice
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

public class Solution {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int left = 0;
        int right = s.length()-1;
        while (left < right) {
            while (left<s.length() && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            if (left == s.length()) {
                return true;
            }
            
            while (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            else {
                left++;
                right--;
            }
        }
        return true;
    }
}