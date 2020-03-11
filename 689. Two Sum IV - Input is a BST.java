689. Two Sum IV - Input is a BST
Given a binary search tree and a number n, find two numbers in the tree that sums up to n.

Example
Example1

Input: 
{4,2,5,1,3}
3
Output: [1,2] (or [2,1])
Explanation:
binary search tree:
    4
   / \
  2   5
 / \
1   3
Example2

Input: 
{4,2,5,1,3}
5
Output: [2,3] (or [3,2])
Notice
Without any extra space.

//iteration
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
 */

public class Solution {
    /*
     * @param : the root of tree
     * @param : the target sum
     * @return: two numbers from tree which sum is n
     */
    public int[] twoSum(TreeNode root, int n) {
        // write your code here
        if (root == null) {
            return null;
        }
        
        Stack<TreeNode> smaller = new Stack<TreeNode>();
        Stack<TreeNode> larger = new Stack<TreeNode>();
        TreeNode head = root;
        while (root != null) {
            smaller.push(root);
            root = root.left;
        }
        while (head != null) {
            larger.push(head);
            head = head.right;
        }
        
        TreeNode s, l;
        while (!smaller.isEmpty() && !larger.isEmpty()) {
            s = smaller.peek();
            l = larger.peek();
            
            if (s.val + l.val == n) {
                return new int[]{s.val, l.val};
            }
            else if (s.val + l.val < n) {
                s = smaller.pop();
                s = s.right;
                while (s != null) {
                    smaller.push(s);
                    s = s.left;
                }
            } 
            else {
                l = larger.pop();
                l = l.left;
                while (l != null) {
                    larger.push(l);
                    l = l.right;
                }
            }
        }
        
        return null;
    }
}