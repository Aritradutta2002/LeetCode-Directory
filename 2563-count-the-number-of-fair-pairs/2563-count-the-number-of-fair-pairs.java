class Solution {
     public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long countUpper = countPairsAtMost(nums, upper);
        long countLower = countPairsAtMost(nums, lower - 1);
        return countUpper - countLower;
    }
    
    private static long countPairsAtMost(int[] nums, int x) {
        long count = 0;
        int i = 0, j = nums.length - 1;
        while(i < j) {
            if(nums[i] + nums[j] <= x) {
                count += j - i;
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
}