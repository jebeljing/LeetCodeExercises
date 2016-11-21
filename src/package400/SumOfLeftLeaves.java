package package400;

import java.util.Stack;

/**
 * Created by jingshanyin on 11/20/16.
 * 404. Sum of Left Leaves
 *
 * Find the sum of all left leaves in a given binary tree.

 Example:

 3
 / \
 9  20
 /  \
 15   7

 There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class SumOfLeftLeaves {


    /*
    Recursive method. For given node we check whether its left child is a leaf.
    If it is the case, we add its value to answer,
    otherwise recursively call method on left child.
    For right child we call method only if it has at least one nonnull child.
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int result = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                result += root.left.val;
            } else {
                result += sumOfLeftLeaves(root.left);
            }
        }
        if (root.right != null) {
            result += sumOfLeftLeaves(root.right);
        }
        return result;
    }

    /*
    Iterative method. Here for each node in the tree we check whether
    its left child is a leaf. If it is true, we add its value to answer,
    otherwise add left child to the stack to process it later.
    For right child we add it to stack only if it is not a leaf.
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) return 0;
        int result = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    result += node.left.val;
                } else {
                    stack.push(node.left);
                }
            }
            if (node.right != null) {
                if (node.right.left != null ||  node.right.right != null) {
                    stack.push(node.right);
                }
            }
        }
        return result;
    }

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }
}
