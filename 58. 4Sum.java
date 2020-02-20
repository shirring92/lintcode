58. 4Sum
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?

Find all unique quadruplets in the array which gives the sum of target.

Example
Example 1:

Input:[2,7,11,15],3
Output:[]

Example 2:

Input:[1,0,-1,0,-2,2],0
Output:
[[-1, 0, 0, 1]
,[-2, -1, 1, 2]
,[-2, 0, 0, 2]]
Notice
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.

public class Solution {
    /**
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (numbers.length < 4) {
            return ans;
        }
        
        Arrays.sort(numbers);
        
        for (int i=0; i<numbers.length; i++) {
            if (i > 0 && numbers[i] == numbers[i-1]) {
                continue;
            }
            for (int j=i+1; j<numbers.length; j++) {
                if (j>i+1 && numbers[j] == numbers[j-1]) {
                    continue;
                }
                int left = j+1;
                int right = numbers.length-1;
                while (left < right) {
                    int sum = numbers[i] + numbers[j] + numbers[left] + numbers[right];
                    if (sum < target) {
                        left++;
                    }
                    else if (sum > target) {
                        right--;
                    }
                    else {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[left]);
                        list.add(numbers[right]);
                        ans.add(list);
                        left++;
                        right--;
                        while (left < right && numbers[left] == numbers[left-1]) {
                            left++;
                        }
                        while (left < right && numbers[right] == numbers[right+1]) {
                            right--;
                        }
                    }
                }
            }
        }
        
        return ans;
    }
}