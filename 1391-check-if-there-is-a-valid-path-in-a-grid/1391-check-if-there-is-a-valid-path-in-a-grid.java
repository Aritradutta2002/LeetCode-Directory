class Solution {

    private static final int[][] DIRECTIONS = {
            {}, // 0 - placeholder
            { 0, 0, 1, 1 }, // 1 - left-right
            { 1, 1, 0, 0 }, // 2 - up-down
            { 0, 1, 1, 0 }, // 3 - down-left
            { 0, 1, 0, 1 }, // 4 - down-right
            { 1, 0, 1, 0 }, // 5 - up-left
            { 1, 0, 0, 1 } // 6 - up-right
    };

    // Row and column deltas for: up, down, left, right
    private static final int[] DR = { -1, 1, 0, 0 };
    private static final int[] DC = { 0, 0, -1, 1 };

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (m == 1 && n == 1) {
            return true;
        }

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0 });
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int street = grid[r][c];

            for (int d = 0; d < 4; d++) {
                if (DIRECTIONS[street][d] == 0) {
                    continue;
                }

                int nr = r + DR[d];
                int nc = c + DC[d];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }

                int nextStreet = grid[nr][nc];
                int opposite = d ^ 1;
                if (DIRECTIONS[nextStreet][opposite] == 1) {
                    if (nr == m - 1 && nc == n - 1) {
                        return true;
                    }
                    visited[nr][nc] = true;
                    queue.offer(new int[] { nr, nc });
                }
            }
        }

        return false;
    }
}