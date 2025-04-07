class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num: nums) {
            sum += num;
        }

        if (sum % 2 != 0)
            return false;

        int targetSum = (sum / 2);
        boolean subsetSum[] = new boolean[targetSum + 1];
        subsetSum[0] = true;

        for (int num: nums) {
            for (int i = targetSum; i >= num; i--) {
                subsetSum[i] = subsetSum[i] || subsetSum[i - num];
            }
        }

        return subsetSum[targetSum];
    }
}