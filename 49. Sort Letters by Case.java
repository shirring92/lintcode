49. Sort Letters by Case
Given a string which contains only letters. Sort it by lower case first and upper case second.

Example
Example 1:
    Input:  "abAcD"
    Output:  "acbAD"

Example 2:
    Input: "ABC"
    Output:  "ABC"
    
Challenge
Do it in one-pass and in-place.

Notice
It's NOT necessary to keep the original order of lower-case letters and upper case letters.


public class Solution {
    /*
     * @param chars: The letter array you should sort by Case
     * @return: nothing
     */
    public void sortLetters(char[] chars) {
        // write your code here
        if (chars == null || chars.length == 0) {
            return;
        }
        
        int left = 0;
        int right = chars.length - 1;
        while (left <= right) {
            while (left <= right && Character.isLowerCase(chars[left])) {
                left++;
            }
            while (left <= right && Character.isUpperCase(chars[right])) {
                right--;
            }
            if (left <= right) {
                swap(chars, left, right);
                left++;
                right--;
            }
        }
    }
    
    private void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }
}