class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        int prefixMax = nums[0];
        for (int i = 0; i < n; i++) {
            // instability = max(nums[0..i]) - min(nums[i..n‑1])
            int instability = prefixMax - suffixMin[i];
            if (instability <= k) {
                return i;
            }

            // update prefix max for the next iteration
            if (i + 1 < n && nums[i + 1] > prefixMax) {
                prefixMax = nums[i + 1];
            }
        }

        return -1; // no 
    }
}