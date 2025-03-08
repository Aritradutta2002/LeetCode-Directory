class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        int n = blocks.length();
        int whiteCount = 0;
        for(int i = 0; i < k; ++i){
            if(blocks.charAt(i) == 'W'){
                whiteCount++;
            }
        }

        int minimumRecolors = whiteCount;
        for(int i = k; i < n; ++i){
            if(blocks.charAt(i) == 'W'){
                whiteCount++;
            }
            if(blocks.charAt(i - k) == 'W'){
                whiteCount--;
            }

            minimumRecolors = Math.min(minimumRecolors, whiteCount);
        }
        return minimumRecolors;           
    }
}