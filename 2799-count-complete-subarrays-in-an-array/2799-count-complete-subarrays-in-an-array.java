class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int[] seen = new int[2001];
        int k = 0;
        for (int num : nums) {
            if (seen[num] == 0) {
                k++;
            }
            seen[num]++;
        }
        return (int)(atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1));
    }
    
    private long atMostKDistinct(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        long res = 0;
        int left = 0;
        int distinct = 0;
        int[] freq = new int[2001];
        for (int right = 0; right < nums.length; right++) {
            if (freq[nums[right]] == 0) {
                distinct++;
            }
            freq[nums[right]]++;
            while (distinct > k) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) {
                    distinct--;
                }
                left++;
            }
            res += (right - left + 1);
        }
        return res;
    }
}