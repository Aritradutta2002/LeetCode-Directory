class Solution {
    public static int maximumDifference(int[] nums) {
            int min = nums[0];
            int maxDiff = -1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > min) {
                    maxDiff = Math.max(maxDiff, nums[i] - min);
                } else {
                    min = Math.min(min, nums[i]);
                }
            }
            return maxDiff;
        }
}