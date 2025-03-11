import java.util.*;

class Solution {
    private boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    private void findNextConsonant(String word, int[] nextConsonant) {
        int n = word.length();
        int next = n;
        for (int i = n - 1; i >= 0; --i) {
            nextConsonant[i] = next;
            if (!isVowel(word.charAt(i)))
                next = i;
        }
    }

    public long countOfSubstrings(String word, int k) {
        int n = word.length();
        int[] nextConsonant = new int[n];
        findNextConsonant(word, nextConsonant);

        long count = 0;
        int consonants = 0;
        Map<Character, Integer> vowelFreq = new HashMap<>();
        int left = 0;
        int right = 0;
        int prev = -1;

        while (right < n) {
            if (prev != right) {
                if (isVowel(word.charAt(right))) {
                    vowelFreq.put(word.charAt(right), vowelFreq.getOrDefault(word.charAt(right), 0) + 1);
                } else {
                    consonants++;
                }
                prev = right;
            }

            if (right >= (5 + k - 1)) {
                if (vowelFreq.size() == 5 && consonants == k) {
                    count += nextConsonant[right] - right;
                }

                // Move left ptr to right: Shrink window
                if ((vowelFreq.size() == 5 && consonants == k) || (consonants > k)) {
                    if (isVowel(word.charAt(left))) {
                        vowelFreq.put(word.charAt(left), vowelFreq.get(word.charAt(left)) - 1);
                        if (vowelFreq.get(word.charAt(left)) == 0) {
                            vowelFreq.remove(word.charAt(left));
                        }
                    } else {
                        consonants--;
                    }
                    left++;
                } else {
                    right++;
                }
            } else {
                right++;
            }
        }
        return count;
    }
}