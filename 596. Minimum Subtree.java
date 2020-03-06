596. Minimum Subtree
Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.

Example
Example 1:

Input:
{1,-5,2,1,2,-4,-5}
Output:1
Explanation:
The tree is look like this:
     1
   /   \
 -5     2
 / \   /  \
1   2 -4  -5 
The sum of whole tree is minimum, so return the root.
Example 2:

Input:
{1}
Output:1
Explanation:
The tree is look like this:
   1
There is one and only one subtree in the tree. So we return 1.
Notice
LintCode will print the subtree which root is your return node.
It's guaranteed that there is only one subtree with minimum sum and the given binary tree is not an empty tree.

//divide & conquer
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
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    class returnType {
        int sum, min;
        TreeNode node, minnode;
        returnType() {
            this.sum = 0;
            this.minnode = null;
            this.min = Integer.MAX_VALUE;
        }
    }
    
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        if (root == null) {
            return root;
        }
        
        return dfs(root).minnode;
    }
    
    private returnType dfs(TreeNode root) {
        returnType ans = new returnType();
        if (root == null) {
            return ans;
        }
        
        returnType left = dfs(root.left);
        returnType right = dfs(root.right);
        
        ans.sum = root.val + left.sum + right.sum;
        ans.min = ans.sum;
        ans.minnode = root;
        
        if (left.min < ans.min) {
            ans.min = left.min;
            ans.minnode = left.minnode;
        }
        if (right.min < ans.min) {
            ans.min = right.min;
            ans.minnode = right.minnode;
        }
        
        return ans;
    }
}