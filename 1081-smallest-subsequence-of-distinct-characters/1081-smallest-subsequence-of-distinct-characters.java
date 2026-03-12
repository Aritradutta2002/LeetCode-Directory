class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        int[] words = new int[26];
        for (char c : s.toCharArray()) {
            words[c - 'a']++;
        }

        boolean[] inStack = new boolean[26];

        // monotonic stack
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            int idx = curr - 'a';

            words[idx]--;
            if (inStack[idx]) {
                continue;
            }

            while (sb.length() > 0) {
                char last = sb.charAt(sb.length() - 1);
                if (last <= curr || words[last - 'a'] == 0) {
                    break;
                }

                inStack[last - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append(curr);
            inStack[idx] = true;

        }

        return sb.toString();
    }
}