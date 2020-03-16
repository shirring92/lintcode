198. Permutation Index II
Given a permutation which may contain repeated numbers, find its index in all the permutations of these numbers, which are ordered in lexicographical order. The index begins at 1.

Example
Example 1:

Input :[1,4,2,2]
Output:3
Example 2:

Input :[1,6,5,3,1]
Output:24

public class Solution {
    /**
     * @param A: An array of integers
     * @return: A long integer
     */
    public long permutationIndexII(int[] A) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<A.length; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], 1);
            }
            else {
                map.put(A[i], map.get(A[i]) + 1);
            }
        }
        
        long ans = 0;
        for (int i=0; i<A.length; i++) {
            ans += count(A, i, map);
            map.put(A[i], map.get(A[i])-1);
        }
        return ans+1;
    }
    
    private long count(int[] A, int index, HashMap<Integer, Integer> map) {
        Set<Integer> set = new HashSet<Integer>();
        long cnt = 0;
        for (int i=A.length-1; i>index; i--) {
            if (A[i] < A[index] && !set.contains(A[i])) {
                set.add(A[i]);
                map.put(A[i], map.get(A[i])-1);
                cnt += getnum(map);
                map.put(A[i], map.get(A[i])+1);
            }
        }
        
        return cnt;
    }
    
    private long fac(int i) {
        long ans = 1;
        for (int j=1; j<=i; j++) {
            ans *= j;
        }
        
        return ans;
    }
    
    private long getnum(HashMap<Integer, Integer> map) {
        int num = 0;
        for (int i: map.keySet()) {
            num += map.get(i);
        }
        
        long cnt = fac(num);
        for (int i: map.keySet()) {
            if (map.get(i) != 0) {
                cnt = cnt/fac(map.get(i));
            }
        }
        
        return cnt;
    }
}