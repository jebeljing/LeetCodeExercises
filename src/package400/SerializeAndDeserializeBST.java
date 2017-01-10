package package400;

import base.TreeNode;

/**
 * Created by yinj on 1/10/2017.
 * 449. Serialize and Deserialize BST
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

 The encoded string should be as compact as possible.

 Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeAndDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(" ");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        if (data.trim().length() == 0) return null;
        String[] chars = data.split(" ");
        if (chars.length == 0) return null;
        int n = chars.length;
        TreeNode newRoot = new TreeNode(Integer.parseInt(chars[0]));
        helper(chars, 1, n, newRoot);
        return newRoot;
    }

    private void helper(String[] chars, int start, int end, TreeNode root) {
        if (root == null) return;
        int i = 0;

        for (i = start; i < end; i++) {
            if (root.val < Integer.parseInt(chars[i])) {
                TreeNode rchild = new TreeNode(Integer.parseInt(chars[i]));
                root.right = rchild;
                break;
            }
        }
        if (i > start) {
            TreeNode lchild = new TreeNode(Integer.parseInt(chars[start]));
            root.left = lchild;
        }
        helper(chars, start + 1, i, root.left);
        helper(chars, i + 1, end, root.right);
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
