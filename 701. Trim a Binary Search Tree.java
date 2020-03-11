701. Trim a Binary Search Tree
Given the root of a binary search tree and 2 numbers min and max, trim the tree such that all the numbers in the new tree are between min and max (inclusive). The resulting tree should still be a valid binary search tree. So, if we get this tree as input:
http://www.ardendertat.com/wp-content/uploads/2012/01/bst.png
and we’re given min value as 5 and max value as 13, then the resulting binary search tree should be:
http://www.ardendertat.com/wp-content/uploads/2012/01/bst_trim.png

Example
Example1

Input: 
{8,3,10,1,6,#,14,#,#,4,7,13}
5
13
Output: {8, 6, 10, #, 7, #, 13}
Explanation:
The picture of tree is in the description.
Example2

Input: 
{1,0,2}
1
2
Output: {1,#,2}
Explanation:
Input is 
  1
 / \
0   2
Output is
  1
   \
    2


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
    /**
     * @param root: given BST
     * @param minimum: the lower limit
     * @param maximum: the upper limit
     * @return: the root of the new tree 
     */
    public TreeNode trimBST(TreeNode root, int minimum, int maximum) {
        // write your code here
        if (root == null) {
            return root;
        }
        
        TreeNode dummy = new TreeNode(-1);
        dummy.right = root;
        TreeNode prev = dummy;
        while (root != null) {
            if (root.val >= minimum) {
                prev = root;
                root = root.left;
            }
            else {
                root = root.right;
                prev.left = root;
            }
        }
        if (dummy.left != null) {
            dummy.right = dummy.left;
        }
        
        root = dummy.right;
        prev = dummy;
        while (root != null) {
            if (root.val <= maximum) {
                prev = root;
                root = root.right;
            }
            else {
                root = root.left;
                prev.right = root;
            }
        }
        
        return dummy.right;
    }
}

//recursion. divide & conquer
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
     * @param root: given BST
     * @param minimum: the lower limit
     * @param maximum: the upper limit
     * @return: the root of the new tree 
     */
    public TreeNode trimBST(TreeNode root, int minimum, int maximum) {
        // write your code here
        if (root == null) {
            return root;
        }
        
        if (root.val < minimum) {
            root = trimBST(root.right, minimum, maximum);
        }
        else if (root.val > maximum) {
            root = trimBST(root.left, minimum, maximum);
        }
        else {
            root.left = trimBST(root.left, minimum, maximum);
            root.right = trimBST(root.right, minimum, maximum);
        }
        
        return root;
    }
}