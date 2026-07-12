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
            ans[i] = Arrays.binarySearch(temp, arr[i]) + 1;
        }
        return ans;
    }
}