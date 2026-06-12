class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];
        int arraySum = 0;
        left[0] = 0;

        for (int i : nums) {
            arraySum += i;
        }

        for (int i = 1; i <= n - 1; i++) {
            left[i] = left[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < n; i++) {
            right[i] = arraySum - nums[i];
            arraySum -= nums[i];
        }

        for (int i = 0; i < n; i++) {
            ans[i] = Math.abs(left[i] - right[i]);
        }

        return ans;
    }
}