class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        int oddCount = 0;
        int evenCount = 0;
        if (nums[0] % 2 == 0) {
            evenCount = 1;
        } else {
            oddCount = 1;
        }
        int alternateCount = 1;
        boolean expecting_even = nums[0] % 2 == 1;

        //    true: expecting EVEN as the next number in sequence
        //    false: expecting ODD as the next number in sequence

        for (int i = 1; i < n; ++i) {
            if ((expecting_even && nums[i] % 2 == 0) || (!expecting_even && nums[i] % 2 == 1)) {
                alternateCount++;
                expecting_even = !expecting_even;
            }

            if (nums[i] % 2 == 1) {
                oddCount++;
            } else {
                evenCount++;
            }
        }
        
        return Math.max(Math.max(evenCount, oddCount), alternateCount);
    }
}