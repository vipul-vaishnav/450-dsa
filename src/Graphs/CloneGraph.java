package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    static public GNode cloneGraph(GNode node) {
        if (node == null) return null;
        Map<GNode, GNode> mpp = new HashMap<>();

        GNode cloneNode = new GNode(node.val);
        mpp.put(node, cloneNode);

        dfs(node, cloneNode, mpp);

        return cloneNode;
    }

    static void dfs(GNode node, GNode cloneNode, Map<GNode, GNode> mpp) {
        for (GNode n : node.neighbors) {
            if (mpp.containsKey(n)) {
                GNode nbr = mpp.get(n);
                cloneNode.neighbors.add(nbr);
            } else {
                GNode newNode = new GNode(n.val);
                mpp.put(n, newNode);
                cloneNode.neighbors.add(newNode);
                dfs(n, newNode, mpp);
            }
        }
    }

    static class GNode {
        public int val;
        public List<GNode> neighbors;

        public GNode() {
            val = 0;
            neighbors = new ArrayList<GNode>();
        }

        public GNode(int _val) {
            val = _val;
            neighbors = new ArrayList<GNode>();
        }

        public GNode(int _val, ArrayList<GNode> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
