package package200;

import base.TreeNode;

/**
 * Created by Jebeljing on 12/23/2016.
 * 222. Count COmplete Tree Nodes
 * Given a complete binary tree, count the number of nodes.

 Definition of a complete binary tree from Wikipedia:
 In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 */
public class CountCompleteTreeNodes {

    private int height(TreeNode root) {
        return root == null ? 0 : 1 + height(root.left);
    }

    public int countNodes(TreeNode root) {
        int h = height(root);
        if (h == 0) return 0;
        if (height(root.right) == h - 1) {
            return (1 << h - 1) + countNodes(root.right);
        } else {
            return (1<<  h - 2) + countNodes(root.left);
        }



        /*if (root == null) {
            return 0;
        }
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result++;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return result;*/
    }
}
