class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        int maxIndex = 0;
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[maxIndex] < dp[i]) {
                maxIndex = i;
            }
        }
        int subsetSize = dp[maxIndex];
        List<Integer> result = new ArrayList<>();
        for (int i = maxIndex; subsetSize > 0; --i) {
            if (nums[maxIndex] % nums[i] == 0 && dp[i] == subsetSize) {
                result.add(nums[i]);
                maxIndex = i;
                --subsetSize;
            }
        }
        return result;
    }
}