/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = 0;
    public int solve(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = 1+solve(root.left);
        int right = 1+solve(root.right);
        max =Math.max(max,left+right);
        return Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);
        return max-2;
    }
}