/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public void sbSerialize(TreeNode root,StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return ;
        }
        sb.append(root.val).append(',');
        sbSerialize(root.left,sb);
        sbSerialize(root.right,sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sbSerialize(root,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String s[] = data.split(",");
        Queue<String>queue = new LinkedList<>(Arrays.asList(s));
        TreeNode root = new TreeNode();
        return rootDeserialize(queue);
    }

    public TreeNode rootDeserialize(Queue<String>queue){
        if(queue.peek().equals("null")){
            queue.poll();
            return null;
        }
        TreeNode node = new TreeNode();
        node.val = Integer.parseInt(queue.poll());
        node.left = rootDeserialize(queue);
        node.right = rootDeserialize(queue);
        return  node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));