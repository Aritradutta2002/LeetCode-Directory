class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l = 0;
        int r = 0;
        int t = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L')
                l++;
            if (c == 'R')
                r++;
            if (c == '_')
                t++;
        }
        return Math.abs(l - r) + t;
    }
}