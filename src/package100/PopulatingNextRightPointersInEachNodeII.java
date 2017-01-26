package package100;

import base.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yinj on 1/26/2017.
 * 117. Populating Next Right Pointers in Each Node II
 * Follow up for problem "Populating Next Right Pointers in Each Node".

 What if the given tree could be any binary tree? Would your previous solution still work?

 Note:

 You may only use constant extra space.
 For example,
 Given the following binary tree,
 1
 /  \
 2    3
 / \    \
 4   5    7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \    \
 4-> 5 -> 7 -> NULL
 */
public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        if (root == null) return;

        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeLinkNode node = null;
        while(!queue.isEmpty()) {
            int size = queue.size();
            TreeLinkNode preNode = null;
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (preNode == null) {
                    preNode = node;
                } else {
                    preNode.next = node;
                    preNode = preNode.next;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }
}
