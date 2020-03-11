106. Convert Sorted List to Binary Search Tree
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

Example
Example 1:
	Input: array = 1->2->3
	Output:
		 2  
		/ \
		1  3
		
Example 2:
	Input: 2->3->6->7
	Output:
		 3
		/ \
	       2   6
		     \
		      7

	Explanation:
	There may be multi answers, and you could return any of them.

//divide & conquer	
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {
        // write your code here
        return dfs(head, null);
    }
    
    private TreeNode dfs(ListNode head, ListNode end) {
        if (head == end) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode root = new TreeNode(slow.val);
        root.left = dfs(head, slow);
        root.right = dfs(slow.next, end);
        
        return root;
    }
}