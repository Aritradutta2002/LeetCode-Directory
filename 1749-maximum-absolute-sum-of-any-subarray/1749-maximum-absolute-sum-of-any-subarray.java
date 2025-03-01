class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currMax = 0, currMin = 0, maxSum = 0;

        for (int num : nums) {
            currMax = Math.max(0, currMax + num);
            currMin = Math.min(0, currMin + num); 
            maxSum = Math.max(maxSum, Math.max(currMax, Math.abs(currMin)));
        }

        return maxSum;
    }
}
