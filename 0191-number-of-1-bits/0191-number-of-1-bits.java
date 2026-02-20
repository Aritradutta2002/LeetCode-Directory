class Solution {
    public int hammingWeight(int n) {
        int len = Integer.toBinaryString(n).length();
        int count = 0;
        for(int i = 0; i < len; i++){
            int bit = (n >> i) & 1;
            if(bit == 1){
                count++;
            }
        }
        return count;
    }
}