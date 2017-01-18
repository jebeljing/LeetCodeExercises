package package100;

import base.TreeNode;

/**
 * Created by jingshanyin on 1/13/17.
 * 108. Convert Sorted Array to Binary Search Tree
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }

        TreeNode head = helper(num, 0, num.length - 1);
        return head;
    }

    private TreeNode helper(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, start, mid - 1);
        node.right = helper(num, mid + 1, end);
        return node;
    }
}
