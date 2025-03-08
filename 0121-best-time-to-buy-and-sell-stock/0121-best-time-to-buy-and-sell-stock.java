class Solution {
    public int maxProfit(int[] prices) {
        
       int leastPrice = prices[0];
       int overallProfit = 0;
       int profitToday = 0;

       for(int i = 0; i < prices.length; i++){
        if(leastPrice > prices[i]){
            leastPrice = prices[i];
        }
        profitToday = prices[i] - leastPrice;
        if(profitToday > overallProfit){
            overallProfit = profitToday;
        }
       }

       return overallProfit;

    }
}