package InterviewDirectory.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by huali on 2018/7/6.
 */
public class cloneGraph1 {
    private HashMap<Integer,UndirectedGraphNode>map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if(node ==null)
            return null;
        if(map.containsKey(node.label))
            return map.get(node.label);
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label,clone);
        for(UndirectedGraphNode neighbor : node.neighbors)
            clone.neighbors.add(cloneGraph(neighbor));
        return clone;
    }
}

class UndirectedGraphNode {
      int label;
      ArrayList<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) {
          label = x;
          neighbors = new ArrayList<UndirectedGraphNode>(); }
  }