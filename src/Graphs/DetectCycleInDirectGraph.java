package Graphs;

import java.util.*;

public class DetectCycleInDirectGraph {
    public static void main(String[] args) {
        int V = 7;

        // ✅ Graph 1: DAG (no cycle)
        Map<Integer, List<Integer>> dag = new HashMap<>();
        dag.put(0, Arrays.asList(1, 2));
        dag.put(1, Arrays.asList(3, 4));
        dag.put(2, Arrays.asList(4, 5));
        dag.put(3, List.of(6));
        dag.put(4, List.of(6));
        dag.put(5, List.of(6));
        dag.put(6, new ArrayList<>()); // no outgoing edges

        System.out.println("DAG (no cycle): " + dag);

        // ❌ Graph 2: Has a cycle (e.g. 2 → 4 → 5 → 2)
        Map<Integer, List<Integer>> cyclicGraph = new HashMap<>();
        cyclicGraph.put(0, Arrays.asList(1, 2));
        cyclicGraph.put(1, List.of(3));
        cyclicGraph.put(2, List.of(4));
        cyclicGraph.put(3, List.of(5));
        cyclicGraph.put(4, List.of(5));
        cyclicGraph.put(5, Arrays.asList(2, 6)); // cycle: 2 → 4 → 5 → 2
        cyclicGraph.put(6, new ArrayList<>());

        System.out.println("Graph with cycle: " + cyclicGraph);

        System.out.println(dfsDetect(V, dag));
        System.out.println(dfsDetect(V, cyclicGraph));

        System.out.println(bfsDetect(V, dag));
        System.out.println(bfsDetect(V, cyclicGraph));
    }

    static boolean dfsDetect(int V, Map<Integer, List<Integer>> g) {
        boolean[] visited = new boolean[V];
        boolean[] inPath = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfs(i, g, visited, inPath)) return true;
        }

        return false;
    }

    private static boolean dfs(int node, Map<Integer, List<Integer>> g, boolean[] visited, boolean[] inPath) {
        visited[node] = true;
        inPath[node] = true;

        for (int nbr : g.get(node)) {
            if (!visited[nbr] && dfs(nbr, g, visited, inPath)) return true;
            else if (inPath[nbr]) return true;
        }

        inPath[node] = false;
        return false;
    }

    static boolean bfsDetect(int V, Map<Integer, List<Integer>> adjList) {
        List<Integer> order = new ArrayList<>();
        Queue<Integer> qu = new LinkedList<>();
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int node : adjList.get(i)) {
                indegree[node]++;
            }
        }

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                qu.offer(i);
            }
        }

        while (!qu.isEmpty()) {
            int curr = qu.poll();
            order.add(curr);
            for (int nbr : adjList.get(curr)) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    qu.offer(nbr);
                }
            }
        }

        return order.size() != V;
    }
}
