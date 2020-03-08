902. Kth Smallest Element in a BST
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Example
Example 1:

Input：{1,#,2},2
Output：2
Explanation：
	1
	 \
	  2
The second smallest element is 2.
Example 2:

Input：{2,1,3},1
Output：1
Explanation：
  2
 / \
1   3
The first smallest element is 1.
Challenge
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Notice
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

//iteration: traversal. not good solution
//O(n), O(h)
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
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    public int kthSmallest(TreeNode root, int k) {
        // write your code here
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
        
        int cnt = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            cnt++;
            if (k == cnt) {
                return node.val;
            }
            
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        
        return -1;
    }
}


//traversal, can also use hashmap to memorize number of nodes for each subtree, so to improve the sitution where need to find the kth smallest frequently
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
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    int value = 0;
    public int kthSmallest(TreeNode root, int k) {
        // write your code here
        dfs(root, k);
        
        return value;
    }
    
    private int dfs(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        
        int left = dfs(root.left, k);
        if (left + 1 == k) {
            value = root.val;
        }
        int right = dfs(root.right, k - left - 1);
        
        return left + right + 1;
    }
}