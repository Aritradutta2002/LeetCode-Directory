class Solution {
    public static int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        int pivotCount = 0;

        // Count the number of pivot occurrences
        for (int num : nums) {
            if (num == pivot) pivotCount++;
        }

        int index = 0;

        // Fill elements less than pivot
        for (int num : nums) {
            if (num < pivot) result[index++] = num;
        }

        // Fill pivot elements
        for (int i = 0; i < pivotCount; i++) {
            result[index++] = pivot;
        }

        // Fill elements greater than pivot
        for (int num : nums) {
            if (num > pivot) result[index++] = num;
        }

        return result;
    }
}