class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] evenFreq = new int[26];
        int[] oddFreq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            int a = s1.charAt(i) - 'a';
            int b = s2.charAt(i) - 'a';

            if ((i & 1) == 0) {
                evenFreq[a]++;
                evenFreq[b]--;
            } else {
                oddFreq[a]++;
                oddFreq[b]--;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (evenFreq[i] != 0 || oddFreq[i] != 0) {
                return false;
            }
        }

        return true;
    }
}