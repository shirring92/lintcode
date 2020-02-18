57. 3Sum
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Example
Example 1:

Input:[2,7,11,15]
Output:[]
Example 2:

Input:[-1,0,1,2,-1,-4]
Output:	[[-1, 0, 1],[-1, -1, 2]]
Notice
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)

The solution set must not contain duplicate triplets.

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (numbers == null || numbers.length < 3) {
            return ans;
        }
        
        Arrays.sort(numbers);
        for (int i=0; i<numbers.length; i++) {
            if (i>0 && numbers[i] == numbers[i-1]) {
                continue;
            }
            int temp = 0 - numbers[i];
            int left = i+1;
            int right = numbers.length-1;
            while (left < right) {
                if (numbers[left] + numbers[right] == temp) {
                    List<Integer> list = new ArrayList<>();
                    list.add(numbers[i]);
                    list.add(numbers[left]);
                    list.add(numbers[right]);
                    ans.add(list);
                    left++;
                    right--;
                    
                    while (left<right && numbers[left] == numbers[left-1]) {
                        left++;
                    }
                    while (left<right && numbers[right] == numbers[right+1]) {
                        right--;
                    }
                }
                else if (numbers[left] + numbers[right] < temp) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return ans;
    }
}