package Graphs;

import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int size = accounts.size();
        var obj = new DSU(size);
        Map<String, Integer> mpp = new HashMap<>();

        for (int idx = 0; idx < size; idx++) {
            List<String> acc = accounts.get(idx);
            int len = acc.size();

            for (int i = 1; i < len; i++) {
                String s = acc.get(i);
                if (mpp.containsKey(s)) {
                    obj.union(mpp.get(s), idx);
                } else {
                    mpp.put(s, idx);
                }
            }
        }

        // collect emails by parent
        Map<Integer, TreeSet<String>> parentToEmails = new HashMap<>();
        for (Map.Entry<String, Integer> entry : mpp.entrySet()) {
            String email = entry.getKey();
            int parent = obj.find(entry.getValue());
            parentToEmails.computeIfAbsent(parent, k -> new TreeSet<>()).add(email);
        }

        // build result
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, TreeSet<String>> entry : parentToEmails.entrySet()) {
            int parent = entry.getKey();
            String name = accounts.get(parent).get(0);
            List<String> merged = new ArrayList<>();
            merged.add(name);
            merged.addAll(entry.getValue());
            res.add(merged);
        }

        return res;

        // List<List<String>> res = new ArrayList<>();

        // for (Map.Entry<String, Integer> entry : mpp.entrySet()) {
        //     String key = entry.getKey();
        //     int value = entry.getValue();
        //     int parent = obj.find(value);
        //     String parentName = accounts.get(parent).get(0);
        //     List<String> merged = new ArrayList<>();
        //     merged.add(parentName);
        //     merged.add()
        //     res.add(merged);
        // }

        // return res;
    }

    static class DSU {
        int n;
        int[] parent;
        int[] rank;

        DSU(int n) {
            this.n = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
            }
            this.rank = new int[n];
        }

        int find(int x) {
            if (this.parent[x] == x) return x;
            this.parent[x] = find(this.parent[x]);
            return this.parent[x];
        }

        void union(int x, int y) {
            int sx = find(x), sy = find(y);
            if (sx == sy) return;
            if (this.rank[sx] < this.rank[sy]) {
                this.parent[sx] = sy;
            } else if (this.rank[sy] < this.rank[sx]) {
                this.parent[sy] = sx;
            } else {
                this.parent[sx] = sy;
                this.rank[sy]++;
            }
        }
    }
}
