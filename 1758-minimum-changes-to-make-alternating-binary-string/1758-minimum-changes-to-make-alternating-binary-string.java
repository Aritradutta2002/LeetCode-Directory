class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int cost0 = 0; 

        for (int i = 0; i < n; i++) {
            char expected = (char) ('0' + (i % 2));
            if (s.charAt(i) != expected)
                cost0++;
        }
        return Math.min(cost0, n - cost0);
    }
}