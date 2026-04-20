class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxDist = 0;
        
        // Find farthest house from the first house
        for(int i = 0; i < n; i++){
            if(colors[i] != colors[0]){
                maxDist = Math.max(maxDist, i);
            }
        }

        // Find farthest house from the last house
        for(int i = 0; i < n; i++){
            if(colors[i] != colors[n - 1]){
                maxDist = Math.max(maxDist, n - 1 - i);
            }
        }
        
        return maxDist;
    }
}