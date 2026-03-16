class Solution {
    public int sumSubarrayMins(int[] arr) {
        final int MOD = 1000000007;
        int n = arr.length;
        long result = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || arr[st.peek()] >= arr[i])) {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                result = (result + (long) (arr[mid] % MOD) * ((mid - left) % MOD) * ((i - mid) % MOD)) % MOD;
            }
            st.push(i);
        }

        return (int) result;

    }
}