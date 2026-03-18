public class Solution {

    public String getHappyString(int n, int k) {
        int total = 3 * (1 << (n - 1));

        if (k > total) return "";

        StringBuilder result = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            result.append('a');
        }

        Map<Character, Character> nextSmallest = new HashMap<>();
        nextSmallest.put('a', 'b');
        nextSmallest.put('b', 'a');
        nextSmallest.put('c', 'a');

        Map<Character, Character> nextGreatest = new HashMap<>();
        nextGreatest.put('a', 'c');
        nextGreatest.put('b', 'c');
        nextGreatest.put('c', 'b');

        int startA = 1;
        int startB = startA + (1 << (n - 1));
        int startC = startB + (1 << (n - 1));

        if (k < startB) {
            result.setCharAt(0, 'a');
            k -= startA;
        } else if (k < startC) {
            result.setCharAt(0, 'b');
            k -= startB;
        } else {
            result.setCharAt(0, 'c');
            k -= startC;
        }

        for (int charIndex = 1; charIndex < n; charIndex++) {
            int midpoint = (1 << (n - charIndex - 1));
            if (k < midpoint) {
                result.setCharAt(
                    charIndex,
                    nextSmallest.get(result.charAt(charIndex - 1))
                );
            } else {
                result.setCharAt(
                    charIndex,
                    nextGreatest.get(result.charAt(charIndex - 1))
                );
                k -= midpoint;
            }
        }

        return result.toString();
    }
}