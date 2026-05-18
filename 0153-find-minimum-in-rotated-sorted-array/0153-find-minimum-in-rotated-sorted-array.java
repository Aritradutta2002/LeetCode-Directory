class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum is in the right half
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // Minimum is in the left half (including mid)
                right = mid;
            } else {
                // nums[mid] == nums[right], cannot determine which side
                // Shrink from the right to avoid duplicates
                right--;
            }
        }

        return nums[left];
    }
}