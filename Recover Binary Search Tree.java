/** Recover Binary Search Tree **/

/*=================================================================

 Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.
=================================================================*/
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
    TreeNode pre;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)){
            return;
        }
        pre = null;
        first = null;
        second = null;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return;
    }
    
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        if(pre==null){
            pre = root;
        }
        else{
            if(root.val<pre.val){
                if(first==null){
                    first = pre;
                }
                second = root;
            }
            pre = root;
        }
        inorder(root.right);
    }
    
    
}