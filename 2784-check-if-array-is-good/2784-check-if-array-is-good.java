class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }
        String base = "";
        for (int i = 1; i <= max; i++) {
            base += String.valueOf(i);
        }
        base += String.valueOf(max);
        String numString = "";
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            numString += String.valueOf(nums[i]);
        }

        return base.equals(numString);
    }
}