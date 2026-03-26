class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        return check(grid) || check(rotate(grid));
    }

    private boolean check(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long topOrLeftSum = 0L;
        long bottomOrRightSum = 0L;
        Map<Long, Integer> seen = new HashMap<>();
        Map<Long, Integer> remaining = new HashMap<>();

        for (int[] row : grid) {
            for (int value : row) {
                long current = value;
                bottomOrRightSum += current;
                remaining.merge(current, 1, Integer::sum);
            }
        }

        for (int cut = 0; cut < m - 1; cut++) {
            for (int value : grid[cut]) {
                long current = value;
                topOrLeftSum += current;
                bottomOrRightSum -= current;
                seen.merge(current, 1, Integer::sum);
                remaining.merge(current, -1, Integer::sum);
            }

            if (topOrLeftSum == bottomOrRightSum) {
                return true;
            }

            if (topOrLeftSum < bottomOrRightSum) {
                long diff = bottomOrRightSum - topOrLeftSum;
                if (remaining.getOrDefault(diff, 0) > 0 && canRemoveFromLowerOrRight(grid, cut, n, diff)) {
                    return true;
                }
            } else {
                long diff = topOrLeftSum - bottomOrRightSum;
                if (seen.getOrDefault(diff, 0) > 0 && canRemoveFromUpperOrLeft(grid, cut, n, diff)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean canRemoveFromLowerOrRight(int[][] grid, int cut, int n, long diff) {
        int lowerRows = grid.length - cut - 1;
        if (lowerRows > 1 && n > 1) {
            return true;
        }
        if (cut == grid.length - 2) {
            return grid[cut + 1][0] == diff || grid[cut + 1][n - 1] == diff;
        }
        if (n == 1) {
            return grid[cut + 1][0] == diff || grid[grid.length - 1][0] == diff;
        }
        return false;
    }

    private boolean canRemoveFromUpperOrLeft(int[][] grid, int cut, int n, long diff) {
        int upperRows = cut + 1;
        if (upperRows > 1 && n > 1) {
            return true;
        }
        if (cut == 0) {
            return grid[0][0] == diff || grid[0][n - 1] == diff;
        }
        if (n == 1) {
            return grid[0][0] == diff || grid[cut][0] == diff;
        }
        return false;
    }

    private int[][] rotate(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] rotated = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][i] = grid[i][j];
            }
        }
        return rotated;
    }
}