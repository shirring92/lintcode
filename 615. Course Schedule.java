615. Course Schedule
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example
Example 1:

Input: n = 2, prerequisites = [[1,0]] 
Output: true
Example 2:

Input: n = 2, prerequisites = [[1,0],[0,1]] 
Output: false

public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        
        //buildGraph + getIndegree
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int[] nodes = new int[numCourses];
        for (int[] item: prerequisites) {
            if (!map.containsKey(item[1])) {
                map.put(item[1], new ArrayList<Integer>());
            }
            map.get(item[1]).add(item[0]);
            nodes[item[0]]++;
        }
        
        //topological sorting
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i=0; i<numCourses; i++) {
            if (nodes[i] == 0) {
                q.offer(i);
            }
        }
        
        int cnt = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            cnt++;
            
            if (map.containsKey(course)) {
                for (int next: map.get(course)) {
                    nodes[next]--;
                    if (nodes[next] == 0) {
                        q.offer(next);
                    }
                }
            }
        }
        
        return cnt == numCourses;
    }
}