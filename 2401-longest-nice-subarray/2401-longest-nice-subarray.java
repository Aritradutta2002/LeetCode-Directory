class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        
        int maxWindowSize = 0;
        int xorSum = 0;
        int currSum = 0;

        while (right < n) {
            currSum += nums[right];
            xorSum ^= nums[right];

            while (xorSum != currSum) {
                currSum -= nums[left];
                xorSum ^= nums[left];
                left++;
            }

            maxWindowSize = Math.max(maxWindowSize, right - left + 1);
            right++;
        }

        return maxWindowSize;
    }
}