class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s2.length();
        if (s1.length() != s2.length())
            return false;
        int[] even1 = new int[26];
        int[] odd1 = new int[26];
        int[] even2 = new int[26];
        int[] odd2 = new int[26];
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                even1[s1.charAt(i) - 'a']++;
                even2[s2.charAt(i) - 'a']++;
            } else {
                odd1[s1.charAt(i) - 'a']++;
                odd2[s2.charAt(i) - 'a']++;
            }
        }
        return Arrays.equals(even1, even2) && Arrays.equals(odd1, odd2);
    }
}