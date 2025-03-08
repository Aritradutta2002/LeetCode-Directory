class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int INF = (int) 1e9;
        int prev[] = new int[amount + 1];
        int curr[] = new int[amount + 1];


        for (int i = 1; i <= amount; i++) {
            if (i % coins[0] == 0) {
                prev[i] = i / coins[0]; 
            } else {
                prev[i] = INF; 
            }
        }

        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= amount; target++) {
                int notTake = prev[target];
                int take = INF;
                if (coins[i] <= target) {
                    take = 1 + curr[target - coins[i]];
                }
                curr[target] = Math.min(take, notTake); 
            }
            System.arraycopy(curr, 0, prev, 0, amount + 1);
        }

        int ans = prev[amount];
        return (ans >= INF) ? -1 : ans;
    }
}
