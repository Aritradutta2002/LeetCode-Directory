class Solution {
    public String makeLargestSpecial(String s) {
        List<String> specials = new ArrayList<>();
        if (s.length() <= 2)
            return s;
        int height = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            height += (s.charAt(i) == '1') ? 1 : -1;
            if (height == 0) {
                // Recurse on inner part: s[start+1 .. i-1]
                String inner = makeLargestSpecial(s.substring(start + 1, i));
                specials.add("1" + inner + "0");
                start = i + 1;
            }
        }

        Collections.sort(specials, Collections.reverseOrder());
        return String.join("", specials);
    }
}