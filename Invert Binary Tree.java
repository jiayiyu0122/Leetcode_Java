/** Invert Binary Tree **/
/*==================================
Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
==================================*/
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
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode cur = root;
        helper(cur);
        return root;
    }
    
    public void helper(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        if(root.left!=null){
            helper(root.left);
        }
        if(root.right!=null){
            helper(root.right);
        }
        
        
    }
}