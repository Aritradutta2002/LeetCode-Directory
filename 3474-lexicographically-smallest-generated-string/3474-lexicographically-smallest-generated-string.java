class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int wordLen = n + m - 1;
        char[] res = new char[wordLen];
        boolean[] isFixed = new boolean[wordLen];

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    int pos = i + j;
                    char c = str2.charAt(j);
                    if (isFixed[pos]) {
                        if (res[pos] != c)
                            return "";
                    } else {
                        res[pos] = c;
                        isFixed[pos] = true;
                    }
                }
            }
        }

        for (int pos = 0; pos < wordLen; pos++) {
            if (!isFixed[pos])
                res[pos] = 'a';
        }

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                boolean equal = true;
                for (int j = 0; j < m; j++) {
                    int pos = i + j;
                    if (res[pos] != str2.charAt(j)) {
                        equal = false;
                        break;
                    }
                }
                if (equal) {
                    int bestPos = -1;
                    int minCount = Integer.MAX_VALUE;
                    for (int j = 0; j < m; j++) {
                        int pos = i + j;
                        if (isFixed[pos])
                            continue;
                        int count = 0;
                        for (int k = 0; k < n; k++) {
                            if (str1.charAt(k) == 'F') {
                                boolean allMatch = true;
                                for (int l = 0; l < m; l++) {
                                    int p = k + l;
                                    if (res[p] != str2.charAt(l)) {
                                        allMatch = false;
                                        break;
                                    }
                                }
                                if (allMatch) {
                                    for (int l = 0; l < m; l++) {
                                        int p = k + l;
                                        if (!isFixed[p])
                                            count++;
                                    }
                                }
                            }
                        }
                        if (count > 0 && count < minCount) {
                            minCount = count;
                            bestPos = pos;
                        } else if (count == minCount && (bestPos == -1 || pos < bestPos)) {
                            bestPos = pos;
                        }
                    }
                    if (bestPos == -1)
                        return "";
                    res[bestPos] = (char) (res[bestPos] + 1);
                    if (res[bestPos] > 'z')
                        return "";
                    i = -1;
                }
            }
        }
        return new String(res);
    }
}