228. Middle of Linked List
Find the middle node of a linked list.

Example
Example 1:

Input:  1->2->3
Output: 2	
Explanation: return the value of the middle node.
Example 2:

Input:  1->2
Output: 1	
Explanation: If the length of list is  even return the value of center left one.	
Challenge
If the linked list is in a data stream, can you find the middle without iterating the linked list again?

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
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public ListNode middleNode(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}