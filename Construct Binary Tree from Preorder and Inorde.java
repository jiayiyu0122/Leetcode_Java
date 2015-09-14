/** Construct Binary Tree from Preorder and Inorder Traversal **/
/*========================================================================
Given preorder and inorder traversal of a tree, construct the binary tree.
========================================================================*/
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null) return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0; i<inorder.length; i++){
            hm.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,hm);
        
    }
    public TreeNode helper(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight, HashMap<Integer, Integer> hm){
        if(preLeft>preRight||inLeft>inRight) return null;
        TreeNode root = new TreeNode(preorder[preLeft]);
        int index = hm.get(preorder[preLeft]);
        root.left = helper(preorder, preLeft+1, index-inLeft+preLeft , inorder, inLeft, index-1,hm);
        root.right = helper(preorder, index-inLeft+preLeft+1, preRight , inorder, index+1, inRight,hm);
        return root;
    }
    
}