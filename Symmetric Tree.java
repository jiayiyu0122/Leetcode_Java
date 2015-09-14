/** Symmetric Tree **/
/*=============================================================================================
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
=============================================================================================*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;
        return helper(root.left,root.right);
    }
    
    public boolean helper(TreeNode n1, TreeNode n2){
        if(n1==null && n2==null) return true;
        if(n1==null && n2!=null) return false;
        if(n1!=null && n2==null) return false;
        if(n1.val==n2.val){
            return helper(n1.left,n2.right)&&helper(n1.right,n2.left);
        }
        return false;
        
    }
}