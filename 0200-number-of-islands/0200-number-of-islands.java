class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int r, int c) {
        if (!boundary(r, c, grid)) return;
        grid[r][c] = '0';
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);

    }

    public boolean boundary(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length)
            return false;
        if (j < 0 || j >= grid[0].length)
            return false;
        if (grid[i][j] != '1')
            return false;
        return true;
    }
}