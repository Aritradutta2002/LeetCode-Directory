class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFind uf = new UnionFind(n);
        
        for (int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }
        
        Map<Integer, List<Integer>> components = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            components.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }
        
        int totalMatches = 0;
        for (List<Integer> indices : components.values()) {
            Map<Integer, Integer> srcFreq = new HashMap<>();
            Map<Integer, Integer> tgtFreq = new HashMap<>();
            
            for (int idx : indices) {
                srcFreq.merge(source[idx], 1, Integer::sum);
                tgtFreq.merge(target[idx], 1, Integer::sum);
            }
            
            for (Map.Entry<Integer, Integer> entry : srcFreq.entrySet()) {
                int val = entry.getKey();
                int srcCount = entry.getValue();
                int tgtCount = tgtFreq.getOrDefault(val, 0);
                totalMatches += Math.min(srcCount, tgtCount);
            }
        }
        
        return n - totalMatches;
    }
    
    class UnionFind {
        int[] parent;
        int[] rank;
        
        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        void union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) return;
            
            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }
}