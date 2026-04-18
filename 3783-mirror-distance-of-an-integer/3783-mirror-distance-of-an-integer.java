class Solution {
    public int mirrorDistance(int n) {
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder(s);
        int reverse = Integer.valueOf(sb.reverse().toString());
        return Math.abs(n - reverse);
    }
}