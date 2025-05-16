class Solution {
   public static List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;

        int[] dp = new int[n];
        int[] prev = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxLength = 1;
        int endIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] == groups[j]) continue;

                if (hammingDistance(words[i], words[j]) == 1 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;

                    if (dp[i] > maxLength) {
                        maxLength = dp[i];
                        endIndex = i;
                    }
                }
            }
        }

        List<String> result = new ArrayList<>();
        while (endIndex != -1) {
            result.add(0, words[endIndex]);
            endIndex = prev[endIndex];
        }

        return result;
    }

    private static int hammingDistance(String a, String b) {
        if (a.length() != b.length()) return -1;

        int distance = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                distance++;
            }
        }

        return distance;
    }
}