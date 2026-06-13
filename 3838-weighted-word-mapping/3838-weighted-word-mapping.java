class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder str = new StringBuilder();
        for (String word : words) {
            int s = 0;
            for (int i = 0; i < word.length(); i++) {
                s += weights[word.charAt(i) - 'a'];
            }
            str.append((char) ('z' - (s % 26)));
        }
        return str.toString();
    }
}