class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        String str = String.valueOf(x);

        StringBuilder sb = new StringBuilder(str);

        return str.equals(sb.reverse().toString());
    }
}