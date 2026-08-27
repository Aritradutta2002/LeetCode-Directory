class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int multiple = k; multiple <= 100; multiple += k) {
            if (!set.contains(multiple)) {
                return multiple;
            }
        }
        return (100 / k + 1) * k;
    }
}