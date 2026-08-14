class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> countMap = new HashMap<>();
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                countMap.put(c, countMap.getOrDefault(c, 0) + 1);
                if (countMap.get(c) > 2) {
                    break;
                }
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
    }
}