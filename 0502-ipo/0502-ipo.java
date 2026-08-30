class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        Arrays.sort(projects, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int idx = 0;
        while (k > 0) {
            while (idx < n && projects[idx][0] <= w) {
                maxHeap.offer(projects[idx][1]);
                idx++;
            }
            if (maxHeap.isEmpty())
                break;
            w += maxHeap.poll();
            k--;
        }
        return w;
    }
}