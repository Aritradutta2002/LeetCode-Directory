class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        int n = nums.length;

        // step - 1 : finding the breakpoint where nums[i + 1] > nums[i]
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                index = i;
                break;
            }
        }

        // step - 2 : finding the just greater than the breakpoint indexed number
        if (index != -1) {
            for (int i = n - 1; i > index; i--) {
                if (nums[i] > nums[index]) {
                    swap(nums, i, index);
                    break;
                }
            }
        }

        // step - 3 : Reverse the array from index + 1 to n - 1
        reverseArray(nums, index + 1, n - 1);
    }

// Implementations of the Inner Methods -  (Nothing else very easy)
    public void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public void reverseArray(int[] nums, int start, int end) {
        while (end > start) {
            swap(nums, start++, end--);
        }
    }
}
