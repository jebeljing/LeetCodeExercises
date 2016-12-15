package self;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jebeljing on 12/14/2016.
 *
 10
 7           5

 3      5      2    15

 output:
 10
 10, 7, 5
 10, 5
 10, 5, 15

 print the path from the root to all the nodes that are divisible by 5

 */
public class TreePathWIthDivisible5 {

    public List<List<Integer>> pathBy5(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper5(result, new ArrayList<Integer>(), root);
        return result;
    }

    private void helper5(List<List<Integer>> result, List<Integer> currPath, TreeNode root) {
        if (root == null) return;
        currPath.add(root.val);
        if (root.val % 5 == 0) {
            List<Integer> newEntry = new ArrayList<>(currPath);
            result.add(newEntry);
        }
        helper5(result, currPath, root.left);
        if (!currPath.isEmpty()) {
            currPath.remove(currPath.size() - 1);
        }
        helper5(result, currPath, root.right);
    }
}
