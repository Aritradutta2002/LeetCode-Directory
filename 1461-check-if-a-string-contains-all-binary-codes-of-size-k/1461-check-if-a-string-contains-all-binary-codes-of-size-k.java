public class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < (1 << k)) {
            return false;
        }

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
        }

        return set.size() == (1 << k);
    }
}