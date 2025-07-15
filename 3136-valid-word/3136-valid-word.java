class Solution {
    public boolean isValid(String word) {
         int vowelCount = 0;
        int consonantCount = 0;
        int charCount = 0;
        
        for(char ch : word.toCharArray()) {
            if(ch >= '0' && ch <= '9') {
                charCount++;
            } else if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                charCount++;
                if("aeiouAEIOU".indexOf(ch) != -1) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            } else {
                return false; 
            }
        }
        
        return charCount >= 3 && vowelCount > 0 && consonantCount > 0;
    }
}