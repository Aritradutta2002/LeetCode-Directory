class Solution {
    public boolean judgeCircle(String moves) {
        int countUD = 0;
        int countLR = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'R')
                countLR++;
            if (ch == 'L')
                countLR--;
            if (ch == 'U')
                countUD++;
            if (ch == 'D')
                countUD--;
        }
        return ((countLR == 0) && (countUD == 0));
    }
}