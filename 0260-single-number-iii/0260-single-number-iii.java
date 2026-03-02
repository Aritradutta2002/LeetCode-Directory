class Solution {
    public int[] singleNumber(int[] nums) {
        int firstElement = 0;
        int secondElement = 0;
        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }
        int differentiatingBit = (xor & -xor);
        for(int num : nums){
            if((num & differentiatingBit) != 0){
                firstElement ^= num;
            }
        }

        secondElement = (firstElement ^ xor);

        return new int[] {firstElement, secondElement};
    }
}