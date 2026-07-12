class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int[] temp = new int[set.size()];
        int idx = 0;
        for (int i : set) {
            temp[idx++] = i;
        }
        Arrays.sort(temp);
        for (int i = 0; i < n; i++) {
            ans[i] = binarySearch(arr[i], temp);
        }
        return ans;
    }

    public int binarySearch(int number, int[] arr) {
        int low = 0;
        int high = arr.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (number == arr[mid])
                return mid+1;
            if (number > arr[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}