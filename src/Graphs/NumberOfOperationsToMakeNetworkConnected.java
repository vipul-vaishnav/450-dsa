package Graphs;

import java.util.*;

public class NumberOfOperationsToMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        var obj = new DisjointSet(n);
        int cables = 0;

        for (int[] cn : connections) {
            if (obj.find(cn[0]) == obj.find(cn[1])) cables++;
            else {
                obj.union(cn[0], cn[1]);
            }
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (obj.find(i) == i) components++;
        }

        int opsNeeded = components - 1;
        return cables >= opsNeeded ? opsNeeded : -1;
    }

    public int makeConnected2(int n, int[][] connections) {
        int components = 0;
        if (connections.length < n - 1) return -1;
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] cn : connections) {
            int from = cn[0], to = cn[1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, adj, visited);
            }
        }

        return connections.length >= components - 1 ? components - 1 : -1;
    }

    void dfs(int node, Map<Integer, List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        List<Integer> nbrs = adj.get(node);
        for (int n : nbrs) {
            if (!visited[n]) dfs(n, adj, visited);
        }
    }

    static class DisjointSet {
        int n;
        int[] parent;
        int[] rank;
        int[] size;

        DisjointSet(int n) {
            this.n = n;
            this.parent = new int[n];
            this.rank = new int[n];
            this.size = new int[n];
            Arrays.fill(size, 1);
            Arrays.fill(parent, -1);
        }

        int getParent(int n) {
            return this.parent[n];
        }

        int find(int n) {
            if (getParent(n) == -1) {
                return n;
            }

            this.parent[n] = find(getParent(n));
            return this.parent[n];
        }

        void union(int n1, int n2) {
            int s1 = find(n1);
            int s2 = find(n2);

            if (s1 == s2) return;

            if (this.rank[s1] < this.rank[s2]) {
                this.parent[s1] = s2;
            } else if (this.rank[s1] > this.rank[s2]) {
                this.parent[s2] = s1;
            } else {
                this.parent[s1] = s2;
                rank[s2]++;
            }
        }

        void unionBySize(int n1, int n2) {
            int s1 = find(n1);
            int s2 = find(n2);

            if (s1 == s2) return;

            if (this.size[s1] < this.size[s2]) {
                this.parent[s1] = s2;
                this.size[s2] += this.size[s1];
            } else {
                this.parent[s2] = s1;
                this.size[s1] += this.size[s2];
            }
        }
    }
}
