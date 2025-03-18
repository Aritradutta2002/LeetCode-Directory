class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int longestSubarray = 0;
        int currSubarray = 0;

        for(int j = 0, i = 0; i < n; i++){
            while( (currSubarray & nums[i]) != 0){
                currSubarray ^= nums[j++];
            }
           longestSubarray = Math.max(longestSubarray, (i - j) + 1);
           currSubarray |= nums[i]; 
        }
        return longestSubarray;
    }
}