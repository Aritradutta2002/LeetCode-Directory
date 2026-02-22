class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()  != goal.length()){
            return false;
        }
        
        String search = s.concat(s);

        return search.contains(goal);
    }
}