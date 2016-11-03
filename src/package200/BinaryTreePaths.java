package package200;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jebeljing on 11/2/2016.
 *  Given a binary tree, return all root-to-leaf paths.
 *  For example, given the following binary tree:
 1
 /   \
 2     3
 \
 5

 All root-to-leaf paths are:

 ["1->2->5", "1->3"]
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root != null) bTreePathsHelper(root, "", result);
        return result;
    }

    private void bTreePathsHelper(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null) result.add(path + root.val);
        if (root.left != null) bTreePathsHelper(root.left, path + root.val + "->", result);
        if (root.right != null) bTreePathsHelper(root.right, path + root.val + "->", result);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
