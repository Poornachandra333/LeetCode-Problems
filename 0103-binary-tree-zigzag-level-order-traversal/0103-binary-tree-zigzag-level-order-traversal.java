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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>>list = new ArrayList<>();
        Deque<TreeNode>dq = new ArrayDeque<>();
        dq.add(root);
        int level = 0;
        while(!dq.isEmpty()){
            int size = dq.size();
            List<Integer>row = new ArrayList<>();
            for(int i=0;i<size;i++){
                if(level%2==0){
                    TreeNode curr = dq.pollFirst();
                    row.add(curr.val);
                    if(curr.left!=null){
                        dq.addLast(curr.left);
                    }
                    if(curr.right!=null){
                        dq.addLast(curr.right);
                    }
                }
                else{
                    TreeNode curr = dq.pollLast();
                    row.add(curr.val);
                    if(curr.right!=null){
                        dq.addFirst(curr.right);
                    }
                    if(curr.left!=null){
                        dq.addFirst(curr.left);
                    }
                }
            }
            level++;
            list.add(row);
        }
        return list;
    }
}