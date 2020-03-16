197. Permutation Index
Given a permutation which contains no repeated number, find its index in all the permutations of these numbers, which are ordered in lexicographical order. The index begins at 1.

Example
Example 1:

Input:[1,2,4]
Output:1
Example 2:

Input:[3,2,1]
Output:6

//iteration
public class Solution {
    /**
     * @param A: An array of integers
     * @return: A long integer
     */
    public long permutationIndex(int[] A) {
        // write your code here
        long ans = 0;
        
        int cnt = 0;
        long sum = 0;
        for (int i=0; i<A.length-1; i++) {
            cnt = count(i, A);
            sum += cnt*perm(A.length-i-1);
        }
        
        return sum+1;
    }
    
    private int count(int index, int[] A) {
        int cnt = 0;
        for (int i=A.length-1; i>index; i--) {
            if (A[i] < A[index]) {
                cnt++;
            }
        }
        
        return cnt;
    }
    
    private long perm(int i) {
        long ans = 1;
        for (int j=1; j<=i; j++) {
            ans *= j;
        }
        
        return ans;
    }
}