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
    int max = Integer.MIN_VALUE;
    public int solve(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = solve(root.left);
        int right = solve(root.right);
        int head = Math.max(root.val,root.val+left+right);
        max = Math.max(max,head);
        max = Math.max(max,Math.max(left+root.val,right+root.val));
        return Math.max(root.val,Math.max(left+root.val,right+root.val));
    }
    public int maxPathSum(TreeNode root) {
        int ans = solve(root);
        return Math.max(max,ans);
    }
}