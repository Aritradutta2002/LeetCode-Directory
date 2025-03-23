class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) nums[i] * nums[i];
        }
        merge(nums);
        return nums;
    }

    public static void merge(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int mid = nums.length / 2;
        int[] leftarr = new int[mid];
        int[] rightarr = new int[nums.length - mid];
        for (int i = 0; i < mid; i++) {
            leftarr[i] = nums[i];
        }
        for (int j = mid; j < nums.length; j++) {
            rightarr[j - mid] = nums[j];
        }
        merge(leftarr);
        merge(rightarr);
        mergearr(leftarr, rightarr, nums);
    }

    public static void mergearr(int[] leftarr, int[] rightarr, int[] nums) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftarr.length && j < rightarr.length) {
            if (leftarr[i] < rightarr[j]) {
                nums[k] = leftarr[i];
                i++;
                k++;
            } else {
                nums[k] = rightarr[j];
                j++;
                k++;
            }
        }
        while (i < leftarr.length) {
            nums[k] = leftarr[i];
            i++;
            k++;
        }
        while (j < rightarr.length) {
            nums[k] = rightarr[j];
            j++;
            k++;
        }
    }
}