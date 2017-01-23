package package100;

import base.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jingshanyin on 1/19/17.
 * 116. Populating Next Right Pointers in Each Node
 * Given a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:

 You may only use constant extra space.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 For example,
 Given the following perfect binary tree,
 1
 /  \
 2    3
 / \  / \
 4  5  6  7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \  / \
 4->5->6->7 -> NULL
 */
public class PopulatingNextRightPointersInEachNode {
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