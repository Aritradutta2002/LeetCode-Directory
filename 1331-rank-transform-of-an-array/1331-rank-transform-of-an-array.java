class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        HashMap<Integer, Integer> rank = new HashMap<>();
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || sorted[i] != sorted[i - 1]) {
                rank.put(sorted[i], ++r);
            }
        }
        for (int i = 0; i < n; i++) {
            ans[i] = rank.get(arr[i]);
        }
        return ans;
    }
}