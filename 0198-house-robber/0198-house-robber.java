class Solution {
    public int rob(int[] nums) {
        int prev2 = 0;
        int prev1 = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int rob = nums[i] + prev2;
            int skip = prev1;
            int curr = Math.max(rob, skip);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}