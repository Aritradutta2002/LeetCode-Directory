class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        int sum = 0;
        int pos = 0;
        
        for (int i = 0; i < n; ++i) {
            while (sum + diff[i] < nums[i]) {
                if (pos == queries.length)
                    return -1;
                
                int start = queries[pos][0];
                int end = queries[pos][1];
                int val = queries[pos][2];
                pos++;
                
                if (end < i) continue; 

                diff[Math.max(start, i)] += val;
                if (end + 1 < n) diff[end + 1] -= val;
            }
            sum += diff[i];
        }
        return pos;
    }
}

