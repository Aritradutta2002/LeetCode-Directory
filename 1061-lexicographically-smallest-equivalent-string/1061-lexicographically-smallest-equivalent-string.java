class Solution {
    private int[] parent;
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
  
        parent = new int[26];
        for (int i = 0; i < 26; ++i) {
            parent[i] = i;
        }

        for (int i = 0; i < s1.length(); ++i) {
            int indexS1 = s1.charAt(i) - 'a';
            int indexS2 = s2.charAt(i) - 'a';
          
        
            int parentS1 = find(indexS1);
            int parentS2 = find(indexS2);
          
     
            if (parentS1 < parentS2) {
                parent[parentS2] = parentS1;
            } else {
                parent[parentS1] = parentS2;
            }
        }


        StringBuilder result = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            char smallestEquivalentChar = (char) (find(ch - 'a') + 'a');
            result.append(smallestEquivalentChar);
        }
        return result.toString();
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}