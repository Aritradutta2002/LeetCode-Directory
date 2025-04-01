import java.util.*;

class Solution {
    private static final int[][] MOVES = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public int[] maxPoints(int[][] grid, int[] queries) {
        int qLen = queries.length;
        int[] res = new int[qLen];
        int rows = grid.length, cols = grid[0].length;
        int totalCells = rows * cols;
        int[] thresholds = new int[totalCells + 1];
        int[][] minVal = new int[rows][cols];
        Arrays.stream(minVal).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));
        minVal[0][0] = grid[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, grid[0][0]});
        int count = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            thresholds[++count] = curr[2];
            for (int[] move : MOVES) {
                int newRow = curr[0] + move[0], newCol = curr[1] + move[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && minVal[newRow][newCol] == Integer.MAX_VALUE) {
                    minVal[newRow][newCol] = Math.max(curr[2], grid[newRow][newCol]);
                    pq.offer(new int[]{newRow, newCol, minVal[newRow][newCol]});
                }
            }
        }

        for (int i = 0; i < qLen; i++) {
            int target = queries[i], left = 0, right = totalCells;
            while (left < right) {
                int mid = (left + right + 1) >>> 1;
                if (thresholds[mid] < target) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            res[i] = left;
        }
        return res;
    }
}
