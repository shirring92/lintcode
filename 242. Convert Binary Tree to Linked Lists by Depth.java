242. Convert Binary Tree to Linked Lists by Depth
Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).

Example
Example 1:

Input: {1,2,3,4}
Output: [1->null,2->3->null,4->null]
Explanation: 
        1
       / \
      2   3
     /
    4
Example 2:

Input: {1,#,2,3}
Output: [1->null,2->null,3->null]
Explanation: 
    1
     \
      2
     /
    3


/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        List<ListNode> ans=new ArrayList<ListNode>();
        if (root == null) {
            return ans;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            ListNode dummy = new ListNode(0);
            ListNode prev = dummy;
            for (int i=0; i<size; i++) {
                TreeNode tnode = q.poll();
                prev.next = new ListNode(tnode.val);
                
                if (tnode.left != null) {
                    q.offer(tnode.left);
                }
                if (tnode.right != null) {
                    q.offer(tnode.right);
                }

                prev = prev.next;
            }
            ans.add(dummy.next);
        }
        
        return ans;
    }
}