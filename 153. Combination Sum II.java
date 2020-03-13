153. Combination Sum II
Given an array num and a number target. Find all unique combinations in num where the numbers sum to target.

Example
Example 1:

Input: num = [7,1,2,5,1,6,10], target = 8
Output: [[1,1,6],[1,2,5],[1,7],[2,6]]
Example 2:

Input: num = [1,1,1], target = 2
Output: [[1,1]]
Explanation: The solution set must not contain duplicate combinations.
Notice
Each number in num can only be used once in one combination.
All numbers (including target) will be positive integers.
Numbers in a combination a1, a2, … , ak must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak)
Different combinations can be in any order.
The solution set must not contain duplicate combinations.

//recursion O(2^n)
public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (num == null || num.length == 0) {
            return ans;
        }
        
        Arrays.sort(num);
        
        helper(num, target, 0, new ArrayList<Integer>(), ans);
        
        return ans;
    }
    
    private void helper(int[] num, int target, int index, List<Integer> list, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        if (index == num.length) {	//can be skiped. if index = num.length, it won't go into the for loop
            return;
        }
        
        for (int i=index; i<num.length; i++) {
            if (i > index && num[i] == num[i-1]) {
                continue;
            }
            if (target < num[i]) {
                return;
            }
            list.add(num[i]);
            helper(num, target - num[i], i + 1, list, ans);
            list.remove(list.size() - 1);
         }
    }
}