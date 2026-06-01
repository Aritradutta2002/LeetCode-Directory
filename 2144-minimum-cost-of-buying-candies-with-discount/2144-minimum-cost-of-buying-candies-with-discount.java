class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int totalCost = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            if ((cost.length - i) % 3 != 0) {
                totalCost += cost[i];
            }
        }
        return totalCost;
    }
}