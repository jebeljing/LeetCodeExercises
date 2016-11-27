package package100;

import base.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Jebeljing on 11/27/2016.
 * 107. BInary Tree Level Order Traversal II
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7

 return its bottom-up level order traversal as:

 [
 [15,7],
 [9,20],
 [3]
 ]

 */
public class BinaryTreeLevelOrderTraversalII {


    //BFS
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            result.add(0, subList);
        }
        return result;
    }

    //DFS
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }
    private void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) return;
        if (level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list, root.left, level + 1);
        levelMaker(list, root.right, level + 1);
        list.get(list.size() - level - 1).add(root.val);
    }

}
