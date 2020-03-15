16. Permutations II
中文English
Given a list of numbers with duplicate number in it. Find all unique permutations.

Example
Example 1:

Input: [1,1]
Output:
[
  [1,1]
]
Example 2:

Input: [1,2,2]
Output:
[
  [1,2,2],
  [2,1,2],
  [2,2,1]
]
Challenge
Using recursion to do it is acceptable. If you can do it without recursion, that would be great!

//recursion
public class Solution {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<Integer>(), ans, new boolean[nums.length]);

        return ans;
    }
    
    private void helper(int[] nums, int k, List<Integer> list, List<List<Integer>> ans, boolean[] map) {
        if (k == nums.length) {
            ans.add(new ArrayList<>(list));
        }
        
        int last = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (map[i]) {
                continue;
            }
            
            if (nums[i] == last) {
                continue;
            }
            
            last = nums[i];
            list.add(nums[i]);
            map[i] = true;
            helper(nums, k+1, list, ans, map);
            list.remove(list.size()-1);
            map[i] = false;
        }
    }
};

//non-recursion
public class Solution {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        ans.add(new ArrayList<Integer>());
        
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            int size = ans.size();
            for (int j=0; j<size; j++) {
                List<Integer> list = ans.get(0);
                ans.remove(0);
                set.remove(list);
                int pos = list.size();
                for (int k=0; k<=pos; k++) {
                    List<Integer> newlist = new ArrayList<>(list);
                    newlist.add(k, nums[i]);
                    if (!set.contains(newlist)) {
                        ans.add(newlist);
                        set.add(newlist);
                    }
                }
            }
        }

        return ans;
    }
};