15. Permutations
Given a list of numbers, return all possible permutations.

Example
Example 1:

Input: [1]
Output:
[
  [1]
]
Example 2:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
Challenge
Do it without recursion.

Notice
You can assume that there is no duplicate numbers in the list.

//DFS. recursion
public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        helper(nums, 0, set, list, ans);
            
        return ans;
    }
    
    private void helper(int[] nums, int k, Set<Integer> set, List<Integer> list, List<List<Integer>> ans) {
        if (k == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for (int i=0; i<nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            
            list.add(nums[i]);
            set.add(nums[i]);
            helper(nums, k+1, set, list, ans);
            list.remove(list.size()-1);
            set.remove(nums[i]);
        }
    }
}

//non-recursion
public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        
        ans.add(new ArrayList<Integer>());
        for (int i=0; i<nums.length; i++) {
            int size = ans.size();
            for (int j=0; j<size; j++) {
                List<Integer> list = ans.get(0);
                ans.remove(0);
                int pos = list.size();
                for (int k=0; k<=pos; k++) {
                    List<Integer> newlist = new ArrayList<>(list);
                    newlist.add(k, nums[i]);
                    ans.add(newlist);
                }
            }
        }
        
        return ans;
    }
}