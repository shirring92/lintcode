102. Linked List Cycle
Given a linked list, determine if it has a cycle in it.



Example
	Example 1:
		Input: 21->10->4->5,  then tail connects to node index 1(value 10).
		Output: true
		
	Example 2:
		Input: 21->10->4->5->null
		Output: false
	
	```
Challenge
Follow up:
Can you solve it without using extra space?

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null && fast.next != null){
            if(slow == fast || slow == fast.next) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return false;
    }
}