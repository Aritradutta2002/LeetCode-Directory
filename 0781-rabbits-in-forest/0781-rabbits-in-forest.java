class Solution {
    public int numRabbits(int[] answers) {
        int ans = 0;
        int[] count = new int[1001]; 
        for (int i = 0; i < answers.length; i++) {
            count[answers[i]]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                ans += (i + 1) * ((count[i] + i) / (i + 1));
            }
        }
        return ans;
    }
}