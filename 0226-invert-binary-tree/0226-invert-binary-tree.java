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
    public TreeNode solve(TreeNode root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return root;
        }
        TreeNode left = solve(root.left);
        TreeNode right = solve(root.right);
        TreeNode temp = root.right;
        root.right = left;
        root.left = temp;
        return root;
    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        return solve(root);
    }
}