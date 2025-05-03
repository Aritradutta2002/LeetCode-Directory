class Solution {
     public static int minDominoRotations(int[] tops, int[] bottoms) {
        int rotations = check(tops[0], tops, bottoms);
        if (rotations != -1 || tops[0] == bottoms[0])
            return rotations;
        return check(bottoms[0], tops, bottoms);
    }
 
    private static int check(int x, int[] tops, int[] bottoms) {
        int rotationsTop = 0, rotationsBottom = 0;
        int n = tops.length;
        for (int i = 0; i < n; i++) {
            if (tops[i] != x && bottoms[i] != x)
                return -1;
            else {
                if (tops[i] != x)
                    rotationsTop++;
                if (bottoms[i] != x)
                    rotationsBottom++;
            }
        }
        return Math.min(rotationsTop, rotationsBottom);
    }
}