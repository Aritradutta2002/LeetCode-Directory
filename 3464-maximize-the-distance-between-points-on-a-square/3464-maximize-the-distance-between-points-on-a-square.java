class Solution {
     public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] pos = new long[n];
        long perimeter = 4L * side;

        // Map each point to its 1D perimeter position
        for (int i = 0; i < n; i++) {
            pos[i] = mapToPerimeterPosition(side, points[i][0], points[i][1]);
        }

        Arrays.sort(pos);

        // Duplicate positions shifted by perimeter for circular handling
        long[] d = new long[2 * n];
        for (int i = 0; i < n; i++) {
            d[i] = pos[i];
            d[i + n] = pos[i] + perimeter;
        }

        // Binary search on answer
        long low = 1, high = (4L * side) / k;
        while (low < high) {
            long mid = low + (high - low + 1) / 2;
            if (canSelect(d, n, k, mid, perimeter)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return (int) low;
    }

    private long mapToPerimeterPosition(int side, int x, int y) {
        if (x == 0) return y;                           // left edge
        if (y == side) return (long) side + x;          // top edge
        if (x == side) return 3L * side - y;            // right edge
        return 4L * side - x;                           // bottom edge
    }

    private boolean canSelect(long[] d, int n, int k, long dist, long perimeter) {
        // next[i]: first index j such that d[j] - d[i] >= dist
        int[] next = new int[2 * n];
        int right = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (right <= i) right = i + 1;
            while (right < 2 * n && d[right] - d[i] < dist) right++;
            next[i] = right;
        }

        // Try each original start point
        for (int start = 0; start < n; start++) {
            int cur = start;
            boolean ok = true;
            for (int step = 1; step < k; step++) {
                cur = next[cur];
                if (cur >= start + n) {
                    ok = false;
                    break;
                }
            }
            if (ok && d[cur] - d[start] <= perimeter - dist) {
                return true;
            }
        }
        return false;
    }

}