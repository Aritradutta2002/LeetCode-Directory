class Solution {
    // ---------- DSU ----------
    private static class DSU {
        int[] parent, rank;
        int components;          
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            components = n;
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        boolean union(int a, int b) {
            a = find(a); b = find(b);
            if (a == b) return false;
            if (rank[a] < rank[b]) {
                int t = a; a = b; b = t;
            }
            parent[b] = a;
            if (rank[a] == rank[b]) rank[a]++;
            components--;
            return true;
        }
    }

    // ---------- edge containers ----------
    private static class Edge {
        int u, v, s, must;
        Edge(int u, int v, int s, int must) {
            this.u = u; this.v = v; this.s = s; this.must = must;
        }
    }

    private static class EdgeCost {
        int u, v, cost;
        EdgeCost(int u, int v, int cost) {
            this.u = u; this.v = v; this.cost = cost;
        }
    }

    private static final int INF = 1_000_000_000;

    // ---------- feasibility test ----------
    private boolean feasible(int X, int n, List<Edge> edges, int k) {
        DSU dsu = new DSU(n);
        for (Edge e : edges) {
            if (e.must == 1) {
                if (e.s < X)               // not strong enough and cannot be upgraded
                    return false;
                if (!dsu.union(e.u, e.v)) // creates a cycle -> impossible to be a tree
                    return false;
            }
        }

        // 2) collect usable optional edges with cost 0 or 1
        List<EdgeCost> opt = new ArrayList<>();
        for (Edge e : edges) {
            if (e.must == 0) {
                int cost = INF;
                if (e.s >= X) cost = 0;
                else if (2 * e.s >= X) cost = 1;
                if (cost != INF) opt.add(new EdgeCost(e.u, e.v, cost));
            }
        }

        // 3) Kruskal on cost (0 first, then 1)
        opt.sort(Comparator.comparingInt((EdgeCost ec) -> ec.cost));
        int upgradesUsed = 0;
        for (EdgeCost ec : opt) {
            if (dsu.union(ec.u, ec.v)) {
                if (ec.cost == 1) upgradesUsed++;
                if (dsu.components == 1) break;
            }
        }

        return dsu.components == 1 && upgradesUsed <= k;
    }

    // ---------- main method ----------
    public int maxStability(int n, int[][] edges, int k) {
        List<Edge> edgeList = new ArrayList<>();
        int maxS = 0;
        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];
            edgeList.add(new Edge(u, v, s, must));
            if (s > maxS) maxS = s;
        }

        int lo = 1;
        int hi = maxS * 2; // inclusive upper bound (strength after at most one upgrade)
        while (lo < hi) {
            int mid = (lo + hi + 1) >>> 1; // upper mid to avoid infinite loop
            if (feasible(mid, n, edgeList, k)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return feasible(lo, n, edgeList, k) ? lo : -1;
    }
}