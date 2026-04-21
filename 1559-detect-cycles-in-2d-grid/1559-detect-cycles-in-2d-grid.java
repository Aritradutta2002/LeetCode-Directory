class Solution {
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (dfs(i, j, -1, -1, grid, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int px, int py, char[][] grid, boolean[][] visited) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == grid[x][y]) {
                if (!visited[nx][ny]) {
                    if (dfs(nx, ny, x, y, grid, visited)) {
                        return true;
                    }
                } else if (nx != px || ny != py) {
                    return true;
                }
            }
        }
        return false;
    }
}