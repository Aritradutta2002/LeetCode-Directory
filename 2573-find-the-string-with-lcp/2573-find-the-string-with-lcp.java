class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] word = new char[n];

        char nextChar = 'a';
        for (int i = 0; i < n; i++) {
            if (word[i] != '\0') {
                continue;
            }
            if (nextChar > 'z') {
                return "";
            }

            word[i] = nextChar;
            for (int j = i + 1; j < n; j++) {
                if (lcp[i][j] > 0) {
                    word[j] = nextChar;
                }
            }
            nextChar++;
        }

        int[][] computed = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word[i] == word[j]) {
                    computed[i][j] = computed[i + 1][j + 1] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computed[i][j] != lcp[i][j]) {
                    return "";
                }
            }
        }

        return new String(word);
    }
}