class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = 1000000007;
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] road : roads) {
            adj[road[0]].add(new int[]{road[1], road[2]});
            adj[road[1]].add(new int[]{road[0], road[2]});
        }
        long[] minTime = new long[n];
        Arrays.fill(minTime, Long.MAX_VALUE);
        int[] ways = new int[n];
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        minTime[0] = 0;
        ways[0] = 1;
        pq.add(new long[]{0, 0});
        while (!pq.isEmpty()) {
            long[] p = pq.poll();
            long time = p[0];
            int node = (int) p[1];
            for (int[] it : adj[node]) {
                int adjNode = it[0], travelTime = it[1];
                if (minTime[adjNode] > time + travelTime) {
                    minTime[adjNode] = time + travelTime;
                    ways[adjNode] = ways[node];
                    pq.add(new long[]{minTime[adjNode], adjNode});
                } else if (minTime[adjNode] == time + travelTime) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1] % mod;
    }
}