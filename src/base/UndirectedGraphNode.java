package base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jebeljing on 12/23/2016.
 * Used: 133
 */
public class UndirectedGraphNode {
    /**
     * Definition for undirected graph.
     * */
      public int label;
      public List<UndirectedGraphNode> neighbors;
      public UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
