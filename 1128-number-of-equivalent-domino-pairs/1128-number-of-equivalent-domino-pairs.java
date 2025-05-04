class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];
        int result = 0;

        for (int[] domino : dominoes) {
            int min = Math.min(domino[0], domino[1]);
            int max = Math.max(domino[0], domino[1]);
            count[min * 10 + max]++;
        }

        for (int c : count) {
            result += c * (c - 1) / 2;
        }

        return result;
    }
}