class Solution {
public:
    int countSubmatrices(vector<vector<int>>& grid, int k) {
        int m = grid.size(), n = grid[0].size();
        int cnt = 0;
        if (grid[0][0] <= k)
            cnt++;
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
            if (grid[i][0] <= k)
                cnt++;
        }
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
            if (grid[0][j] <= k)
                cnt++;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] +=
                    grid[i - 1][j] + grid[i][j - 1] - grid[i - 1][j - 1];
                if (grid[i][j] <= k)
                    cnt++;
            }
        }
        return cnt;
    }
};