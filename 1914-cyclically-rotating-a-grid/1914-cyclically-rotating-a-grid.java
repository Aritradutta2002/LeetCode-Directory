class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int layers = Math.min(m, n) / 2;
        int[][] result = new int[m][n];

        for (int layer = 0; layer < layers; layer++) {
            int top = layer, left = layer;
            int bottom = m - 1 - layer, right = n - 1 - layer;

            List<Integer> elements = new ArrayList<>();
            List<int[]> positions = new ArrayList<>();

            for (int j = left; j <= right; j++) {
                elements.add(grid[top][j]);
                positions.add(new int[] { top, j });
            }
            for (int i = top + 1; i <= bottom; i++) {
                elements.add(grid[i][right]);
                positions.add(new int[] { i, right });
            }
            for (int j = right - 1; j >= left; j--) {
                elements.add(grid[bottom][j]);
                positions.add(new int[] { bottom, j });
            }
            for (int i = bottom - 1; i > top; i--) {
                elements.add(grid[i][left]);
                positions.add(new int[] { i, left });
            }

            int len = elements.size();
            int rot = k % len;

            for (int idx = 0; idx < len; idx++) {
                int[] pos = positions.get(idx);
                result[pos[0]][pos[1]] = elements.get((idx + rot) % len);
            }
        }

        return result;
    }
}