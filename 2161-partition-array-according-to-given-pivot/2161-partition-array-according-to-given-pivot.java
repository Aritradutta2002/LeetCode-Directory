class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int a = 0;
        int[] res = new int[nums.length];
        for (int num : nums) {
            if (num < pivot) {
                res[a++] = num;
            }
        }
        for (int num : nums) {
            if (num == pivot) {
                res[a++] = num;
            }
        }
        for (int num : nums) {
            if (num > pivot) {
                res[a++] = num;
            }
        }
        return res;
    }
}