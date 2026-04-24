class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int right = 0;
        int left = 0;
        int free = 0;
        int n = moves.length();

        for(char ch : moves.toCharArray()){
            if(ch == 'R') right++;
            else if(ch == 'L') left++;
            else{
                free++;
            }
        }
        return Math.abs(right - left) + free;
    }
}