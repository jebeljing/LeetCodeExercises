package package100;

import base.TreeNode;

/**
 * Created by jingshanyin on 11/30/16.
 * 111. Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root
 node down to the nearest leaf node.
 */
public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        MinimumDepthOfBinaryTree instance = new MinimumDepthOfBinaryTree();
        instance.minDepth(new TreeNode(1));
    }

    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.right != null) {
            return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;
        } else if (root.left != null) {
            return minDepth2(root.left) + 1;
        }
        return minDepth2(root.right) + 1;
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int result = Integer.MAX_VALUE;
        int currLen = 0;
        return helper(root, result, currLen);
    }

    private int helper(TreeNode root, int result, int currLen) {
        if (root == null) return result;
        if (root.left == null && root.right == null) {
            int newLen = currLen + 1;
            if (newLen < result) result = newLen;
            return result;
        } else {
            int minLeft = Integer.MAX_VALUE;
            int minRight = Integer.MAX_VALUE;
            if (root.left != null) {
                minLeft = helper(root.left, result, currLen + 1);
            }
            if (root.right != null) {
                minRight = helper(root.right, result, currLen + 1);
            }
            return Math.min(minLeft, minRight);
        }

    }
}
