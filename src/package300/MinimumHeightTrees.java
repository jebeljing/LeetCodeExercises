package package300;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jingshanyin on 1/6/17.
 * 310. Minimum Height Trees
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

 Format
 The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

 You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

 Example 1:

 Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

 0
 |
 1
 / \
 2   3
 return [1]

 Example 2:

 Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

 0  1  2
 \ | /
 3
 |
 4
 |
 5
 return [3, 4]

 How many MHTs can a graph have at most?
 (1) According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”

 (2) The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */
public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Set<Integer>[] adj = (Set<Integer>[])new HashSet[n];
        Set<Integer> ans = new HashSet<>();
        for (int i = 0; i < n; i++) {
            ans.add(i);
        }
        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            adj[from].add(to);
            adj[to].add(from);
        }

        Set<Integer> leaves = new HashSet<>();
        while (ans.size() > 2) {
            for (int v: ans) {
                if (adj[v].size() == 1) {
                    leaves.add(v);
                }
            }
            ans.retainAll(leaves);
            for (int v: leaves) {
                int adjNode = adj[v].iterator().next();
                adj[adjNode].remove(v);
            }
            leaves.clear();
        }
        return new ArrayList<>(ans);
    }
}
