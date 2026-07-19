class Solution {
    public String smallestSubsequence(String s) {
        StringBuilder result = new StringBuilder();
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (result.indexOf(String.valueOf(c)) != -1)
                continue;

            while (result.length() > 0 && result.charAt(result.length() - 1) > c
                    && lastIndex[result.charAt(result.length() - 1) - 'a'] > i) {
                result.deleteCharAt(result.length() - 1);
            }
            result.append(c);
        }
        return result.toString();
    }
}