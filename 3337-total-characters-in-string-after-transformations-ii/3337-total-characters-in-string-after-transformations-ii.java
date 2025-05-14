class Solution {
    private static final int MOD = 1_000_000_007;

    public static int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[][] singleStep = buildTransformationMatrix(nums);
        int[][] tStep = matrixPower(singleStep, t);
        long[] freq = new long[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        long total = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                continue;
            }
            for (int j = 0; j < 26; j++) {
                total = (total + freq[i] * tStep[i][j]) % MOD;
            }
        }
        return (int) total;
    }

    private static int[][] buildTransformationMatrix(List<Integer> nums) {
        int[][] mat = new int[26][26];
        for (int i = 0; i < 26; i++) {
            int produce = nums.get(i);
            for (int k = 1; k <= produce; k++) {
                mat[i][(i + k) % 26]++;
            }
        }
        return mat;
    }

    private static int[][] matrixPower(int[][] base, int exp) {
        int n = base.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            result[i][i] = 1;
        }
        int[][] cur = base;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = multiplyMatrices(result, cur);
            }
            cur = multiplyMatrices(cur, cur);
            exp >>= 1;
        }
        return result;
    }

    private static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int n = A.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long sum = 0;
                for (int k = 0; k < n; k++) {
                    sum = (sum + (long) A[i][k] * B[k][j]) % MOD;
                }
                res[i][j] = (int) sum;
            }
        }
        return res;
    }
}