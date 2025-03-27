class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> ans = new HashSet<>();
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    ans.add(words[i]);
                }
            }
        }
        
        return new ArrayList<>(ans); 
    }
}