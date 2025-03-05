class Solution {
    public long coloredCells(int n) {
        
        if(n == 1){
            return 1;
        }

        long i = 0;
        long ans = 1;
        while(n > 0){
            ans += i;
            n--;
            i+=4;
        }

        return ans;
    }
}