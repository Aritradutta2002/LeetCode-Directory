class Solution {
    public int minPartitions(String n) {
        int ans = 0;
        for(char c : n.toCharArray()){
            ans = Math.max(ans, (c - '0'));
        }
        return ans;
    }
}