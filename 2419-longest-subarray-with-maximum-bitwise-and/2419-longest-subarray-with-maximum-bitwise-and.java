class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxElement = nums[0];
        int result = 0;

        for(int i = 1; i < n; i++){
            maxElement = Math.max(maxElement, nums[i]);
        }

        int currMax = maxElement, count = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] == currMax){
                count++;
            } else {
                result = Math.max(result, count);
                count = 0;
            }
        }

        result = Math.max(result, count);

        return result;
    }
}