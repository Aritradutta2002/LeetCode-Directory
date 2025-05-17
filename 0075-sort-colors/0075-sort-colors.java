class Solution {
    public static void sortColors(int[] nums) {
        int n = nums.length;
        sort(nums);
    }

    public static void sort(int[] arr) {
        if (arr == null) {
            return;
        }
        int n = arr.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, n - mid);
        sort(left);
        sort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int leftLength = left.length;
        int rightLength = right.length;
        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < leftLength) {
            arr[k++] = left[i++];
        }
        while (j < rightLength) {
            arr[k++] = right[j++];
        }
    }
}