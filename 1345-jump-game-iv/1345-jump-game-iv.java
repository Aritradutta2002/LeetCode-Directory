class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return 0;

        // Group indices by value for quick lookup of equal elements
        Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueToIndices.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;
        int jumps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            jumps++;

            for (int i = 0; i < size; i++) {
                int index = queue.poll();

                // Try jumping to adjacent indices
                int nextIdx = index + 1;
                if (nextIdx < n && !visited[nextIdx]) {
                    if (nextIdx == n - 1)
                        return jumps;
                    visited[nextIdx] = true;
                    queue.offer(nextIdx);
                }

                int prevIdx = index - 1;
                if (prevIdx >= 0 && !visited[prevIdx]) {
                    visited[prevIdx] = true;
                    queue.offer(prevIdx);
                }

                // Try jumping to indices with same value
                List<Integer> sameValueIndices = valueToIndices.get(arr[index]);
                if (sameValueIndices != null) {
                    for (int j : sameValueIndices) {
                        if (!visited[j]) {
                            if (j == n - 1)
                                return jumps;
                            visited[j] = true;
                            queue.offer(j);
                        }
                    }
                    sameValueIndices.clear(); // Optimization: avoid revisiting same value group
                }
            }
        }

        return jumps;
    }
}