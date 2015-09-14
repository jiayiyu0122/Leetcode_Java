/** count complete tree nodes **/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 1. 计算root沿左边的高度。
// 2. 计算root沿右边的高度。
// 3. 如果左边的高度等于右边的高度， 说明时完整的二叉树。
// 4. 如果不相等， recursive 左边和右边的子树。
// 注意！！ 2的平方要用(2<<(left-1))-1；要不会超时。
public class Solution {
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        int left = getLeftHeight(root)+1;
        int right = getRightHeight(root)+1;
        
        if(left==right){
            return (2<<(left-1))-1;
        }
        else{
            return countNodes(root.left) + countNodes(root.right) +1;
        }
    }
    public int getLeftHeight(TreeNode root){
        if(root==null){ return 0; }
        int count = 0;
        while(root.left !=null){
            count++;
            root = root.left;
        }
        return count;
    }
    public int getRightHeight(TreeNode root){
        if(root==null){ return 0; }
        int count = 0;
        while(root.right !=null){
            count++;
            root = root.right;
        }
        return count;
    }
}