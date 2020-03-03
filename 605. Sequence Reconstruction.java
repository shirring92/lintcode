605. Sequence Reconstruction
Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs. The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 10^4. Reconstruction means building a shortest common supersequence of the sequences in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it). Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.

Example
Example 1:

Input:org = [1,2,3], seqs = [[1,2],[1,3]]
Output: false
Explanation:
[1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence that can be reconstructed.
Example 2:

Input: org = [1,2,3], seqs = [[1,2]]
Output: false
Explanation:
The reconstructed sequence can only be [1,2].
Example 3:

Input: org = [1,2,3], seqs = [[1,2],[1,3],[2,3]]
Output: true
Explanation:
The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
Example 4:

Input:org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]
Output:true


public class Solution {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here
        cornercase:
        if (org.length == 0) {
            for (int[] item: seqs) {
                if (item.length != 0) {
                    return false;
                }
            }
            return true;
        }
        else {
            for (int[] item: seqs) {
                if (item.length != 0) {
                    break cornercase;
                }
            }
            return false;
        }
        
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        buildgraph(seqs, map);
        
        HashMap<Integer, Integer> degree = new HashMap<Integer, Integer>();
        getdegree(map, degree);
        
        Queue<Integer> q = new LinkedList<Integer>();
        return toposort(org, map, degree, q);
    }
    
    private void buildgraph(int[][] seqs, HashMap<Integer, List<Integer>> map) {
        for (int[] item: seqs) {
            for (int i=1; i<item.length; i++) {
                if (!map.containsKey(item[i-1])) {
                    map.put(item[i-1], new ArrayList<Integer>());
                }
                map.get(item[i-1]).add(item[i]);
            }
            if (!map.containsKey(item[item.length-1])) {
                map.put(item[item.length-1], new ArrayList<Integer>());
            }
        }
    }
    
    private void getdegree(HashMap<Integer, List<Integer>> map, HashMap<Integer, Integer> degree) {
        for (int i: map.keySet()) {
            if (!degree.containsKey(i)) {
                degree.put(i, 0);
            }
            for (int j: map.get(i)) {
                if (degree.containsKey(j)) {
                    degree.put(j, degree.get(j) + 1);
                }
                else {
                    degree.put(j, 1);
                }
            }
        }
    }
    
    private boolean toposort(int[] org, HashMap<Integer, List<Integer>> map, HashMap<Integer, Integer> degree, Queue<Integer> q) {
        for (int i: degree.keySet()) {
            if (degree.get(i) == 0) {
                q.offer(i);
            }
        }
        
        int index = 0;
        while (!q.isEmpty()) {
            if (q.size() != 1) {
                return false;
            }
            
            int cur = q.poll();
            if (index >= org.length || cur != org[index]) {
                return false;
            }
            index++;
            
            for (int i: map.get(cur)) {
                degree.put(i, degree.get(i) - 1);
                if (degree.get(i) == 0) {
                    q.offer(i);
                }
            }
        }
        
        return index == org.length;
    }
}