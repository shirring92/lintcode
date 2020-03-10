11. Search Range in Binary Search Tree
Given a binary search tree and a range [k1, k2], return node values within a given range in ascending order.

Example
Example 1:

Input：{5},6,10
Output：[]
        5
it will be serialized {5}
No number between 6 and 10
Example 2:

Input：{20,8,22,4,12},10,22
Output：[12,20,22]
Explanation：
        20
       /  \
      8   22
     / \
    4   12
it will be serialized {20,8,22,4,12}
[12,20,22] between 10 and 22


//iteration. O(n) + O(h)
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
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            if (root.val < k1) {
                break;
            }
            root = root.left;
        }
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val >= k1 && node.val <= k2) {
                ans.add(node.val);
            }
            
            if (node.val < k2) {
                TreeNode right = node.right;
                while (right != null) {
                    stack.push(right);
                    if (right.val < k1) {
                        break;
                    }
                    right = right.left;
                }
            }
        }
        
        return ans;
    }
}

//traverse
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
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        
        dfs(root, k1, k2, ans);
        
        return ans;
    }
    
    private void dfs(TreeNode root, int k1, int k2, List<Integer> ans) {
        if (root == null) {
            return;
        }
        
        if (root.val > k1) {
            dfs(root.left, k1, k2, ans);
        }
        
        if (root.val >= k1 && root.val <= k2) {
            ans.add(root.val);
        }
        
        if (root.val < k2) {
            dfs(root.right, k1, k2, ans);
        }
    }
}