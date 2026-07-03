class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] minLoss = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(minLoss[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        int startLoss = grid.get(0).get(0);
        minLoss[0][0] = startLoss;
        pq.offer(new int[] { 0, 0, startLoss });

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int loss = curr[2];

            if (loss > minLoss[r][c]) {
                continue;
            }

            if (r == m - 1 && c == n - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int nextLoss = loss + grid.get(nr).get(nc);
                    if (nextLoss < minLoss[nr][nc]) {
                        minLoss[nr][nc] = nextLoss;
                        pq.offer(new int[] { nr, nc, nextLoss });
                    }
                }
            }
        }

        return health - minLoss[m - 1][n - 1] >= 1;
    }
}