class Solution {
    public static int[][] moves = {
            { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 },
            { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 }
    };

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        if (n == 1) {
            return 1;
        }

        Queue<Integer> row = new ArrayDeque<>();
        Queue<Integer> col = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        row.offer(0);
        col.offer(0);
        visited[0][0] = true;
        int pathLength = 1;

        while (!row.isEmpty()) {
            int levelSize = row.size();

            for (int i = 0; i < levelSize; i++) {
                int r = row.poll();
                int c = col.poll();

                if (r == n - 1 && c == n - 1) {
                    return pathLength;
                }

                for (int[] move : moves) {
                    int nr = r + move[0];
                    int nc = c + move[1];

                    if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
                        continue;
                    }
                    if (visited[nr][nc] || grid[nr][nc] == 1) {
                        continue;
                    }

                    visited[nr][nc] = true;
                    row.offer(nr);
                    col.offer(nc);
                }
            }

            pathLength++;
        }

        return -1;

    }
}