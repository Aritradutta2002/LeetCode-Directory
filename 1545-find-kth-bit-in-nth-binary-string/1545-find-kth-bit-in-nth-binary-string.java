class Solution {
    public char findKthBit(int n, int k) {
        String[] s = new String[n];
        s[0] = "0";

        for (int i = 1; i < n; i++) {
            s[i] = s[i - 1] + "1" + reverse(invert(s[i - 1]));
        }

        return s[n - 1].charAt(k - 1);

    }

    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static String invert(String s) {
        char[] c = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            c[i] = s.charAt(i) == '0' ? '1' : '0';
        }
        return new String(c);
    }

}