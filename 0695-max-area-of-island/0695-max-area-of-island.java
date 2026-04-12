class Solution {
    private int[] dx = { -1, 1, 0, 0 };
    private int[] dy = { 0, 0, -1, 1 };

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    maxSize = Math.max(maxSize, bfs(i, j, grid, visited));
                }
            }
        }
        return maxSize;
    }

    public int bfs(int r, int c, int[][] grid, boolean[][] visited) {
        int count = 1;
        int n = grid.length, m = grid[0].length;
        Queue<Integer> row = new ArrayDeque<>();
        Queue<Integer> col = new ArrayDeque<>();
        row.offer(r);
        col.offer(c);
        visited[r][c] = true;

        while (!row.isEmpty()) {
            int rr = row.poll();
            int cc = col.poll();
            for (int i = 0; i < 4; i++) {
                int nr = rr + dx[i];
                int nc = cc + dy[i];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1 && !visited[nr][nc]) {
                    count++;
                    visited[nr][nc] = true;
                    row.offer(nr);
                    col.offer(nc);
                }
            }
        }
        return count;
    }
}