/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode solve(TreeNode root,TreeNode p,TreeNode q,TreeNode dummy){
        if(root==null){
            return null;
        }
        if(root==p || root == q){
            return root;
        }
        TreeNode left = solve(root.left,p,q,dummy);
        TreeNode right = solve(root.right,p,q,dummy);
        if(left!=null && right!=null){
            return root;
        }
        if(left!=null){
            return left;
        }
        return right;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solve(root,p,q,null);
    }
}