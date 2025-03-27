class Solution {

    public int minimumIndex(List<Integer> nums) {
        int mostFrequentNum = 0;  
        int maxFrequency = 0;    
        Map<Integer, Integer> frequencyMap = new HashMap<>();  

        for (int value : nums) {
            int currentFrequency = frequencyMap.merge(value, 1, Integer::sum);
            if (maxFrequency < currentFrequency) {
                maxFrequency = currentFrequency;
                mostFrequentNum = value;
            }
        }

        
        int currentFreqCount = 0; 
        for (int i = 1; i <= nums.size(); i++) {
            if (nums.get(i - 1).equals(mostFrequentNum)) {
                currentFreqCount++;
                if (currentFreqCount * 2 > i && (maxFrequency - currentFreqCount) * 2 > nums.size() - i) {
                    return i - 1; 
                }
            }
        }

        return -1; 
    }
}
