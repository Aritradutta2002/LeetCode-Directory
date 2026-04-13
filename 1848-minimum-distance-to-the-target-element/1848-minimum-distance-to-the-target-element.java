class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(nums[i] == target){
                minDiff = Math.min(minDiff, Math.abs(i - start));
            }
        }
        return minDiff;
    }
}