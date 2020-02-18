56. Two Sum
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are zero-based.

Example
Example1:
numbers=[2, 7, 11, 15], target=9
return [0, 1]
Example2:
numbers=[15, 2, 7, 11], target=9
return [1, 2]
Challenge
Either of the following solutions are acceptable:

O(n) Space, O(nlogn) Time
O(n) Space, O(n) Time
Notice
You may assume that each input would have exactly one solution


//time O(n), space O(n)
public class Solution {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i=0; i<numbers.length; i++) {
            if (!map.containsKey(numbers[i])) {
                map.put(numbers[i], new ArrayList<Integer>());
            }
            map.get(numbers[i]).add(i);
        }
        
        for (int i=0; i<numbers.length; i++) {
            int temp = target - numbers[i];
            if (map.containsKey(temp) && temp != numbers[i]) {
                return new int[]{i, map.get(temp).get(0)};
            }
            else if (temp == numbers[i] && map.get(temp).size() >= 2) {
                return new int[]{map.get(temp).get(0), map.get(temp).get(1)};
            }
        }
        
        return new int[2];
    }
}