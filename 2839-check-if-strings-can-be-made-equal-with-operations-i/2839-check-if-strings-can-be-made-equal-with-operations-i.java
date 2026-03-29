class Solution {
    public static boolean canBeEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2))
            return true;

        char[] c1 = s2.toCharArray();
        if (s1.equals(swap(c1, 0, 2)))
            return true;
        char[] c2 = s2.toCharArray();
        if (s1.equals(swap(c2, 1, 3)))
            return true;
        char[] c3 = s2.toCharArray();
        swap(c3, 0, 2);
        swap(c3, 1, 3);
        if (s1.equals(new String(c3)))
            return true;

        return false;
    }

    public static String swap(char[] temp, int i, int j) {
        char t = temp[i];
        temp[i] = temp[j];
        temp[j] = t;
        return new String(temp);
    }
}