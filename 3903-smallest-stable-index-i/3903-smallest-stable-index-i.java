class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int maxValue = nums[i];
            int minValue = nums[i];

            for (int j = 0; j < i; j++) {
                maxValue = Math.max(nums[j], maxValue);
            }

            for (int j = i + 1; j < n; j++) {
                minValue = Math.min(nums[j], minValue);
            }

            if (maxValue - minValue <= k) {
                return i;
            }
        }

        return -1;
    }
}