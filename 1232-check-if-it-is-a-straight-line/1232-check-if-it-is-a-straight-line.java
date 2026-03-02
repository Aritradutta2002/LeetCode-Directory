class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        /*
            m = (y2 - y1)/(x2 - x1) slope of the line should same, i.e; 
            m1 = m2 = m3 = ....mi
        */
        int n = coordinates.length;
        int dy = coordinates[1][1] - coordinates[0][1];
        int dx = coordinates[1][0] - coordinates[0][0];

        for (int i = 2; i < n; i++) {
            int currDY = coordinates[i][1] - coordinates[i - 1][1];
            int currDX = coordinates[i][0] - coordinates[i - 1][0];

            if((dy * currDX) != (currDY * dx)){
                return false;
            }
        }

        return true;
    }
}