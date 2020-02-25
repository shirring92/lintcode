545. Top k Largest Numbers II
Implement a data structure, provide two interfaces:

add(number). Add a new number in the data structure.
topk(). Return the top k largest numbers in this data structure. k is given when we create the data structure.
Example
Example1

Input: 
s = new Solution(3);
s.add(3)
s.add(10)
s.topk()
s.add(1000)
s.add(-99)
s.topk()
s.add(4)
s.topk()
s.add(100)
s.topk()
		
Output: 
[10, 3]
[1000, 10, 3]
[1000, 10, 4]
[1000, 100, 10]

Explanation:
s = new Solution(3);
>> create a new data structure, and k = 3.
s.add(3)
s.add(10)
s.topk()
>> return [10, 3]
s.add(1000)
s.add(-99)
s.topk()
>> return [1000, 10, 3]
s.add(4)
s.topk()
>> return [1000, 10, 4]
s.add(100)
s.topk()
>> return [1000, 100, 10]
Example2

Input: 
s = new Solution(1);
s.add(3)
s.add(10)
s.topk()
s.topk()

Output: 
[10]
[10]

Explanation:
s = new Solution(1);
>> create a new data structure, and k = 1.
s.add(3)
s.add(10)
s.topk()
>> return [10]
s.topk()
>> return [10]


//add O(logn), topk O(nlogn), space O(k)
public class Solution {
    /*
    * @param k: An integer
    */
    Queue<Integer> q;
    int size;
    public Solution(int k) {
        // do intialization if necessary
        q = new PriorityQueue<Integer>(k);
        size = k;
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        q.offer(num);
        if (q.size() > size) {
            q.poll();
        }
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        // write your code here
        List<Integer> ans = new ArrayList<Integer>();
        while (!q.isEmpty()) {
            ans.add(q.poll());
        }
        Collections.reverse(ans);
        for (int i=0; i<ans.size(); i++) {
            q.offer(ans.get(i));
        }
        
        return ans;
    }
}