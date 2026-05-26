class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }

        int count = 0;
        for (char c : set) {
            if (Character.isLowerCase(c)) {
                char upper = Character.toUpperCase(c);
                if (set.contains(upper)) {
                    count++;
                }
            }
        }
        return count;
    }
}