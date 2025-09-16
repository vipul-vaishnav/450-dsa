package Graphs;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfVerticesToReactAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();

        int[] indegree = new int[n];
        for (List<Integer> edge : edges) {
            indegree[edge.get(1)]++;
        }

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) res.add(i);
        }

        return res;
    }
}
