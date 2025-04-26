class Solution {
   public static long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int n = nums.length;
        int minIndex = -1, maxIndex = -1, leftBound = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                leftBound = i;
            }
            if (nums[i] == minK) {
                minIndex = i;
            }
            if (nums[i] == maxK) {
                maxIndex = i;
            }
            ans += Math.max(0, Math.min(minIndex, maxIndex) - leftBound);
        }

        return ans;
    }
}