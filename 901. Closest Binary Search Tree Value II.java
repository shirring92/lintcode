901. Closest Binary Search Tree Value II
Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Example
Example 1:

Input:
{1}
0.000000
1
Output:
[1]
Explanation：
Binary tree {1},  denote the following structure:
 1
Example 2:

Input:
{3,1,4,#,2}
0.275000
2
Output:
[1,2]
Explanation：
Binary tree {3,1,4,#,2},  denote the following structure:
  3
 /  \
1    4
 \
  2
Challenge
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?

Notice
Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.


//iteration. O(h+k). O(h)
//if balanced tree, O(logn+k). O(logn)
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
    /**
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code here
        List<Integer> ans = new ArrayList<>();
        
        Stack<TreeNode> smaller = new Stack<TreeNode>();
        Stack<TreeNode> larger = new Stack<TreeNode>();
        
        while (root != null) {
            if (root.val > target) {
                larger.add(root);
                root = root.left;
            }
            else {
                smaller.add(root);
                root = root.right;
            }
        }
        
        for (int i=0; i<k; i++) {
            if (!larger.isEmpty() && !smaller.isEmpty()) {
                int small = smaller.peek().val;
                int large = larger.peek().val;
                if (target - (double) small <= (double) large - target) {
                    ans.add(small);
                    TreeNode node = smaller.pop();
                    if (node .left != null) {
                        node = node.left;
                        while(node != null) {
                            smaller.push(node);
                            node = node.right;
                        }
                    }
                }
                else {
                    ans.add(large);
                    TreeNode node = larger.pop();
                    if (node.right != null) {
                        node = node.right;
                        while (node != null) {
                            larger.push(node);
                            node = node.left;                            
                        }
                    }
                }
            }
            else if (!larger.isEmpty()) {
                TreeNode node = larger.pop();
                ans.add(node.val);
                if (node.right != null) {
                    node = node.right;
                    while (node != null) {
                        larger.push(node);
                        node = node.left;                            
                    }
                }
            }
            else if (!smaller.isEmpty()) {
                TreeNode node = smaller.pop();
                ans.add(node.val);
                if (node .left != null) {
                    node = node.left;
                    while(node != null) {
                        smaller.push(node);
                        node = node.right;
                    }
                }
            }
        }
        
        return ans;
    }
}