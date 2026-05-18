class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int index = queue.poll();

            // Check if current index has value 0
            if (arr[index] == 0) {
                return true;
            }

            // Jump forward by arr[index]
            int nextIdx = index + arr[index];
            if (nextIdx < arr.length && !visited[nextIdx]) {
                visited[nextIdx] = true;
                queue.offer(nextIdx);
            }

            // Jump backward by arr[index]
            int prevIdx = index - arr[index];
            if (prevIdx >= 0 && !visited[prevIdx]) {
                visited[prevIdx] = true;
                queue.offer(prevIdx);
            }
        }

        return false;
    }
}