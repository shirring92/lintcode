862. Next Closest Time
Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.

You may assume the given input string is always valid. For example, "01:34", "12:09" are valid. "1:34", "12:9" are invalid.

Example
Example 1:

Input: "19:34"
Output: "19:39"
Explanation:
  The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  
  It is not 19:33, because this occurs 23 hours and 59 minutes later.
Example 2:

Input: "23:59"
Output: "22:22"
Explanation: It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.

//
public class Solution {
    /**
     * @param time: the given time
     * @return: the next closest time
     */
    public String nextClosestTime(String time) {
        // write your code here
        int[] digit = new int[4];
        int index = 0;
        for (int i=0; i<time.length(); i++) {
            if (Character.isDigit(time.charAt(i))) {
                digit[index++] = time.charAt(i) - '0';
            }
        }
        
        int[] sort = digit.clone();
        Arrays.sort(sort);
        
        for (int i=0; i<4; i++) {
            if (sort[i] > digit[3] && sort[i] <= 9) {
                digit[3] = sort[i];
                return build(digit);
            }
        }
        digit[3] = sort[0];
        
        for (int i=0; i<4; i++) {
            if (sort[i] > digit[2] && sort[i] <= 5) {
                digit[2] = sort[i];
                return build(digit);
            }
        }
        digit[2] = sort[0];
        
        for (int i=0; i<4; i++) {
            if (sort[i] > digit[1] && sort[i] <= 3) {
                digit[1] = sort[i];
                return build(digit);
            }
        }
        digit[1] = sort[0];
        
        for (int i=0; i<4; i++) {
            if (sort[i] > digit[0] && sort[i] <=2) {
                digit[0] = sort[i];
                return build(digit);
            }
        }
        digit[0] = sort[0];
        
        return build(digit);
    }
    
    private String build(int[] digit) {
        return digit[0]+""+digit[1]+":"+digit[2]+""+digit[3];
    }
}