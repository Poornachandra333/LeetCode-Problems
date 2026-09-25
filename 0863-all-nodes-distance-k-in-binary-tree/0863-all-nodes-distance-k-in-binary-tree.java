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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode>parent = new HashMap<>();
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);
        parent.put(root,null);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                if(curr.left!=null){
                    parent.put(curr.left,curr);
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    parent.put(curr.right,curr);
                    queue.add(curr.right);
                }
            }
        }
        Queue<TreeNode>q = new LinkedList<>();
        q.add(target);
        List<Integer>list = new ArrayList<>();
        HashSet<TreeNode>hs = new HashSet<>();
        hs.add(target);
        while(!q.isEmpty() && k-->0){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null && !hs.contains(curr.left)){
                    hs.add(curr.left);
                    q.add(curr.left);
                }
                if(curr.right!=null && !hs.contains(curr.right)){
                    q.add(curr.right);
                    hs.add(curr.right);
                }
                if(parent.get(curr)!=null && !hs.contains(parent.get(curr))){
                    q.add(parent.get(curr));
                    hs.add(parent.get(curr));
                }
            }
        }
        while(!q.isEmpty()){
            list.add(q.peek().val);
            q.poll();
        }
        return list;
    }
}