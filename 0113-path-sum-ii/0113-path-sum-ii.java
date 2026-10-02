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
    public void helper(TreeNode root,int targetSum,List<Integer>path,List<List<Integer>>list){
        if(root==null){
            return ;
        }
        if(root.left == null && root.right == null && root.val == targetSum){
            path.add(root.val);
            list.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return ;
        }
        path.add(root.val);
        helper(root.left,targetSum-root.val,path,list);
        path.remove(path.size()-1);
        path.add(root.val);
        helper(root.right,targetSum-root.val,path,list);
        path.remove(path.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>list = new ArrayList<>();
        List<Integer>path = new ArrayList<>();
        helper(root,targetSum,path,list);
        return list;
    }
}