class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            for(int j = 0; j < dictionary.length; j++){
                if(isWithinTwoEdits(queries[i], dictionary[j])){
                    ans.add(queries[i]);
                    break;
                }
            }
        }
        return ans;
    }

    private boolean isWithinTwoEdits(String a, String b) {
        int diffs = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diffs++;
                if (diffs > 2)
                    return false;
            }
        }
        return true;
    }
}