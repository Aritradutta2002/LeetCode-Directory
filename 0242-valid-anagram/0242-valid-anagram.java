class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            count[c - 'a']++;
        }
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            count[c - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(count[i] != 0){
                return false;
            }
        }

        return true;
    }
}
