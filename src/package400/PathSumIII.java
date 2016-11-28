package package400;

import base.TreeNode;

/**
 * Created by Jebeljing on 11/27/2016.
 * 437. Path Sum III
 *
 * You are given a binary tree in which each node contains an integer value.

 Find the number of paths that sum to a given value.

 The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

 The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

 Example:

 root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

 10
 /  \
 5   -3
 / \    \
 3   2   11
 / \   \
 3  -2   1

 Return 3. The paths that sum to 8 are:

 1.  5 -> 3
 2.  5 -> 2 -> 1
 3. -3 -> 11

 */
public class PathSumIII {

    public int pathSum(TreeNode root, int sum) {
        int result = 0;
        if (root == null) {
            return result;
        }
        result += helper(root, sum);
        result += pathSum(root.left, sum) + pathSum(root.right, sum);
        return result;
    }

    private int helper(TreeNode root, int sum) {
        int res = 0;
        if (root.val == sum) {
            res++;
        }
        if (root.left != null) {
            res += helper(root.left, sum - root.val);
        }
        if (root.right != null) {
            res += helper(root.right, sum - root.val);
        }
        return res;
    }
}

