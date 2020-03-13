18. Subsets II
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Example
Example 1:

Input: [0]
Output:
[
  [],
  [0]
]
Example 2:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
Challenge
Can you do it in both recursively and iteratively?

Notice
Each element in a subset must be in non-descending order.
The ordering between two subsets is free.
The solution set must not contain duplicate subsets.

//iteration
public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());
        if (nums == null || nums.length == 0) {
            return ans;
        }
        
        Arrays.sort(nums);
        
        int size = 0;
        for (int i=0; i<nums.length; i++) {
            int start = 0;
            if (i>0 && nums[i] == nums[i-1]) {
                start = size;
            }
            size = ans.size();
            for (int j=start; j<size; j++) {
                List<Integer> list = new ArrayList<>(ans.get(j));
                list.add(nums[i]);
                ans.add(list);
            }
        }
        
        return ans;
    }
}

//recursion
public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());
        if (nums == null || nums.length == 0) {
            return ans;
        }
        
        Arrays.sort(nums);
        
        helper(nums, 0, new ArrayList<Integer>(), ans);
        
        return ans;
    }
    
    private void helper(int[] nums, int index, List<Integer> list, List<List<Integer>> ans) {
        if (index == nums.length) {
            return;
        }
        
        for (int i=index; i<nums.length; i++) {
            if (i > index && nums[i] == nums[i-1]) {
                continue;
            }
            
            list.add(nums[i]);
            ans.add(new ArrayList<>(list));
            helper(nums, i+1, list, ans);
            list.remove(list.size()-1);
        }
    }
}