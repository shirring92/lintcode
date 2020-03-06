597. Subtree with Maximum Average
Given a binary tree, find the subtree with maximum average. Return the root of the subtree.

Example
Example 1

Input：
{1,-5,11,1,2,4,-2}
Output：11
Explanation:
The tree is look like this:
     1
   /   \
 -5     11
 / \   /  \
1   2 4    -2 
The average of subtree of 11 is 4.3333, is the maximun.
Example 2

Input：
{1,-5,11}
Output：11
Explanation:
     1
   /   \
 -5     11
The average of subtree of 1,-5,11 is 2.333,-5,11. So the subtree of 11 is the maximun.
Notice
LintCode will print the subtree which root is your return node.
It's guaranteed that there is only one subtree with maximum average.

//DFS
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
     * @return: the root of the maximum average of subtree
     */
    TreeNode maxnode;
    double max;
    
    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        maxnode = root;
        max = -Integer.MAX_VALUE;
        if (root == null) {
            return root;
        }
        
        int[] dummy = dfs(root);
        
        return maxnode;
    }
    
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        
        int[] ans = new int[2];
        ans[0] = left[0] + right[0] + 1;
        ans[1] = left[1] + right[1] + node.val;
        
        double avg = (double)ans[1] / (double)ans[0];
        //System.out.println(node.val+" "+ans[0]+" "+ans[1]+" "+avg);
        if (avg > max) {
            max = avg;
            maxnode = node;
        }
        
        return ans;
    }
}