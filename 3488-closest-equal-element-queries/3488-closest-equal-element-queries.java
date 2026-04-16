class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> pos = new HashMap<>();

        for (int i = 0; i < n; i++) {
            pos.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int[] bestAtIndex = new int[n];
        Arrays.fill(bestAtIndex, -1);

        for (List<Integer> list : pos.values()) {
            int m = list.size();
            if (m == 1)
                continue;

            for (int k = 0; k < m; k++) {
                int cur = list.get(k);
                int prev = list.get((k - 1 + m) % m);
                int next = list.get((k + 1) % m);

                int d1 = circularDistance(cur, prev, n);
                int d2 = circularDistance(cur, next, n);
                bestAtIndex[cur] = Math.min(d1, d2);
            }
        }

        List<Integer> ans = new ArrayList<>(queries.length);
        for (int q : queries)
            ans.add(bestAtIndex[q]);
        return ans;
    }

    private int circularDistance(int a, int b, int n) {
        int d = Math.abs(a - b);
        return Math.min(d, n - d);
    }
}