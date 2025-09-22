class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Step 1: Count frequency of each element
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            //     ↑ key        ↑ key           ↑ default
        }
        
        // Step 2: Find maximum frequency
        int maxFreq = 0;
        for(int frequency : map.values()){
            maxFreq = Math.max(maxFreq, frequency);
        }
        
        // Step 3: Sum all frequencies equal to maxFreq
        int totalCount = 0;
        for(int frequency : map.values()){
            if(frequency == maxFreq){
                totalCount += frequency;
            }
        }
        
        return totalCount;
    }
}
