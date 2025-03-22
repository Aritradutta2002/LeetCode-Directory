class Solution {
    class DSU {
        int[] parent, size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }

        void union(int x, int y) {
            int xRoot = find(x), yRoot = find(y);
            if (xRoot == yRoot)
                return;

            if (size[xRoot] > size[yRoot]) {
                parent[yRoot] = xRoot;
                size[xRoot] += size[yRoot];
            } else {
                parent[xRoot] = yRoot;
                size[yRoot] += size[xRoot];
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        Map<Integer, Integer> edgeCount = new HashMap<>();

        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }

        for (int[] edge : edges) {
            int root = dsu.find(edge[0]);
            edgeCount.put(root, edgeCount.getOrDefault(root, 0) + 1);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i) {
                int v = dsu.size[i];
                int e = edgeCount.getOrDefault(i, 0);

                if ((v * (v - 1)) / 2 == e) {
                    result++;
                }
            }
        }

        return result;
    }
}