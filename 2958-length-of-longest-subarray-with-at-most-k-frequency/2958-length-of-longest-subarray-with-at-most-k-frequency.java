class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int start = 0, maxLength = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int end = 0; end < nums.length; end++) {
            freq.put(nums[end], freq.getOrDefault(nums[end], 0) + 1);

            while (freq.get(nums[end]) > k) {
                freq.put(nums[start], freq.get(nums[start]) - 1);
                if (freq.get(nums[start]) == 0)
                    freq.remove(nums[start]);
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}