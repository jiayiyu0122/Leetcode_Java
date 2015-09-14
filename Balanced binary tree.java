// Blanced binary tree
/*How to determine if a binary tree is height-balanced?
An empty tree is height-balanced. A non-empty binary tree T is balanced if:
1) Left subtree of T is balanced
2) Right subtree of T is balanced
3) The difference between heights of left subtree and right subtree is not more than 1.
*/
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
    public int height(TreeNode root){
        if(root==null) return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(Math.abs(height(root.left)-height(root.right))<=1){
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }
}