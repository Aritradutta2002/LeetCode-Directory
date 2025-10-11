class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Long, Long> freq = new HashMap<>();
        for (int p : power) {
            freq.put((long)p, freq.getOrDefault((long)p, 0L) + 1);
        }
        
        List<Long> unique = new ArrayList<>(freq.keySet());
        Collections.sort(unique);
        
        int n = unique.size();
        long[] dp = new long[n + 1];
        
        for (int i = n - 1; i >= 0; i--) {
            long cur = unique.get(i);
            long take = cur * freq.get(cur);
            
            int j = i + 1;
            while (j < n && unique.get(j) <= cur + 2) {
                j++;
            }
            
            take += dp[j];
            long skip = dp[i + 1];
            
            dp[i] = Math.max(take, skip);
        }
        
        return dp[0];
    }
}
