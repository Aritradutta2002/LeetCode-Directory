class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 1; i <= 101; i++) {
            if (!set.contains(i * k)) {
                return i * k;
            }
        }
        return -1;
    }
}