class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int n = s.length();
        int k = 10;
        if (n < k) {
            return ans;
        }
        for (int i = 0; i <= (n - k); i++) {
            String str = s.substring(i, i + k);
            int count = map.getOrDefault(str, 0) + 1;
            map.put(str, count);
            if (count == 2) {
                ans.add(str);
            }
        }

        return ans;
    }
}