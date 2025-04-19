class Solution {
    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums); // Sort the array first
        return countPairsLessThanOrEqual(nums, upper) - countPairsLessThanOrEqual(nums, lower - 1);
    }
    
    private static long countPairsLessThanOrEqual(int[] nums, int value) {
        long count = 0;
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            if (nums[left] + nums[right] <= value) {
                count += right - left;
                left++;
            } else {
                right--;
            }
        }
        
        return count;
    }
}