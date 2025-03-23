import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] words) {
        if (words == null || words.length == 0) {
            return new ArrayList<>();
        }

        List<String> commonChars = new ArrayList<>();
        for (char c : words[0].toCharArray()) {
            commonChars.add(String.valueOf(c));
        }

        for (int i = 1; i < words.length; i++) {
            List<String> currentChars = new ArrayList<>();
            for (char c : words[i].toCharArray()) {
                currentChars.add(String.valueOf(c));
            }
            commonChars.retainAll(currentChars);
        }

        return commonChars;
    }
}