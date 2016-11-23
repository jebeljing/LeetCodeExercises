package package100;

import base.TreeNode;

/**
 * Created by jingshanyin on 11/22/16.
 * 110. Balanced Binary Tree
 *
 * Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined
 as a binary tree in which the depth of the two subtrees of
 every node never differ by more than 1.
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return 1;
        } else {
            return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        }
    }
}
