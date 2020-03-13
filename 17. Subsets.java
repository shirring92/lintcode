17. Subsets
Given a set of distinct integers, return all possible subsets.

Example
Example 1:

Input: [0]
Output:
[
  [],
  [0]
]
Example 2:

Input: [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
Challenge
Can you do it in both recursively and iteratively?

Notice
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.

//recursion
public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<Integer>(), ans);
        ans.add(new ArrayList<Integer>());
        
        return ans;
    }
    
    private void helper(int[] nums, int index, List<Integer> list, List<List<Integer>> ans) {
        if (index == nums.length) {
            return;
        }
        
        for (int i=index; i<nums.length; i++) {
            list.add(nums[i]);
            ans.add(new ArrayList<>(list));
            helper(nums, i+1, list, ans);
            list.remove(list.size()-1);
        }
    }
}

//iteration
public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        
        Arrays.sort(nums);
        ans.add(new ArrayList<Integer>());
        for (int i=0; i<nums.length; i++) {
            int size = ans.size();
            for (int j=0; j<size; j++) {
                List<Integer> list = ans.get(j);
                list.add(nums[i]);
                ans.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }
        }
        
        return ans;
    }
}