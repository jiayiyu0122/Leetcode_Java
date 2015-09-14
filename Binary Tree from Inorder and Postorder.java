/** Construct Binary Tree from Inorder and Postorder Traversal **/
/*==============================================================================
Given inorder and postorder traversal of a tree, construct the binary tree.
==============================================================================*/
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0 && postorder.length==0) return null;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0; i<inorder.length; i++){
            hm.put(inorder[i],i);   
        }
        return helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1,hm);
        
    }
    public TreeNode helper(int[] inorder, int leftin, int rightin, int[] postorder, int leftpost, int rightpost, HashMap<Integer,Integer> hm){
        if(leftin>rightin || leftpost>rightpost) return null;
        TreeNode root = new TreeNode(postorder[rightpost]);
        int index = hm.get(postorder[rightpost]);
        root.left = helper(inorder,leftin,index-1,postorder,leftpost,leftpost+index-1-leftin,hm);
        root.right = helper(inorder,index+1,rightin,postorder,leftpost+index-leftin,rightpost-1,hm);
        return root;
    }
}