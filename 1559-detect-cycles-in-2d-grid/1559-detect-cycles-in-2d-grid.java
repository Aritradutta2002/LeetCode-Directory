class Solution {
    private int[] dx = { -1, 1, 0, 0 };
    private int[] dy = { 0, 0, -1, 1 };

    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (bfs(i, j, -1, -1, grid, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean bfs(int rr, int cc, int px, int py, char[][] grid, boolean[][] visited) {
        Queue<int[]> child = new ArrayDeque<>();
        Queue<int[]> parent = new ArrayDeque<>();
        int n = grid.length;
        int m = grid[0].length;
        visited[rr][cc] = true;
        child.offer(new int[] { rr, cc });
        parent.offer(new int[] { px, py });

        while (!child.isEmpty()) {
            int[] c = child.poll();
            int[] p = parent.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + c[0];
                int ny = dy[i] + c[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m
                        && grid[nx][ny] == grid[c[0]][c[1]]
                        && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    child.offer(new int[] { nx, ny });
                    parent.offer(new int[] { c[0], c[1] });
                }

                else if (nx >= 0 && nx < n && ny >= 0 && ny < m
                        && visited[nx][ny]
                        && grid[nx][ny] == grid[c[0]][c[1]]
                        && (nx != p[0] || ny != p[1])) {
                    return true;
                }
            }
        }
        return false;
    }
}