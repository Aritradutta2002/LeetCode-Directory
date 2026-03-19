class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];

        dfsWalk(matrix, 0, 0, 0, 0, rows * cols, visited, result);
        return result;
    }

    private void dfsWalk(int[][] matrix, int row, int col, int dir, int visitedCount,
            int total, boolean[][] visited, List<Integer> result) {
        if (visitedCount == total) {
            return;
        }

        result.add(matrix[row][col]);
        visited[row][col] = true;

        int[] dr = { 0, 1, 0, -1 };
        int[] dc = { 1, 0, -1, 0 };

        int nextRow = row + dr[dir];
        int nextCol = col + dc[dir];

        if (!isValid(nextRow, nextCol, matrix.length, matrix[0].length) || visited[nextRow][nextCol]) {
            dir = (dir + 1) % 4;
            nextRow = row + dr[dir];
            nextCol = col + dc[dir];
        }

        dfsWalk(matrix, nextRow, nextCol, dir, visitedCount + 1, total, visited, result);
    }

    private boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}