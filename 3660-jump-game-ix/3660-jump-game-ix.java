class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];
        int[] ans = new int[n];

        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }

        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }

        int start = 0;
        int componentMax = nums[0];
        for (int i = 0; i < n; i++) {
            componentMax = Math.max(componentMax, nums[i]);
            boolean isBoundary = (i == n - 1) || (prefixMax[i] <= suffixMin[i + 1]);
            if (isBoundary) {
                for (int j = start; j <= i; j++) {
                    ans[j] = componentMax;
                }
                if (i + 1 < n) {
                    start = i + 1;
                    componentMax = nums[start];
                }
            }
        }

        return ans;
    }
}