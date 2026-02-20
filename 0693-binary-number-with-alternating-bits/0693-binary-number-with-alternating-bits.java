class Solution {
    public boolean hasAlternatingBits(int n) {
        int len = 32 - Integer.numberOfLeadingZeros(n);;
        for(int i = 1; i < len; i++){
            int prevBit = (n >> (i - 1)) & 1;
            int currBit = (n >> (i)) & 1;
            if(prevBit == currBit){
                return false;
            }
        }
        return true;
    }
}