class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int startR = -1, startC = -1;
        int[][] litterIndex = new int[m][n];
        for (int[] row : litterIndex)
            Arrays.fill(row, -1);
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    startR = i;
                    startC = j;
                } else if (c == 'L') {
                    litterIndex[i][j] = idx++;
                }
            }
        }
        int fullMask = (1 << idx) - 1;

        // BFS state: (r, c, mask, energy). Track visited to avoid revisiting.
        boolean[][][][] visited = new boolean[m][n][1 << idx][energy + 1];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] { startR, startC, 0, energy, 0 });
        visited[startR][startC][0][energy] = true;

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], mask = cur[2], e = cur[3], moves = cur[4];
            if (mask == fullMask)
                return moves;
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;
                char cell = classroom[nr].charAt(nc);
                if (cell == 'X')
                    continue;
                int ne = e - 1;
                if (ne < 0)
                    continue; // no energy to move
                if (cell == 'R')
                    ne = energy; // reset to full capacity
                int nmask = mask;
                if (cell == 'L')
                    nmask |= (1 << litterIndex[nr][nc]);
                if (!visited[nr][nc][nmask][ne]) {
                    visited[nr][nc][nmask][ne] = true;
                    queue.add(new int[] { nr, nc, nmask, ne, moves + 1 });
                }
            }
        }
        return -1;
    }
}