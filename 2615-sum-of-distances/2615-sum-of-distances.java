class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];

        Map<Integer, Long> cnt = new HashMap<>();
        Map<Integer, Long> sum = new HashMap<>();

        // Left contributions
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            long c = cnt.getOrDefault(x, 0L);
            long s = sum.getOrDefault(x, 0L);

            ans[i] += c * i - s;

            cnt.put(x, c + 1);
            sum.put(x, s + i);
        }

        cnt.clear();
        sum.clear();

        for (int i = n - 1; i >= 0; i--) {
            int x = nums[i];
            long c = cnt.getOrDefault(x, 0L);
            long s = sum.getOrDefault(x, 0L);

            ans[i] += s - c * i;

            cnt.put(x, c + 1);
            sum.put(x, s + i);
        }

        return ans;
    }
}