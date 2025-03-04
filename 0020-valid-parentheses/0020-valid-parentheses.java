class Solution {
   public static boolean isValid(String s){
        Stack <Character> st = new Stack<>();
        for(var ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            else{

                if(st.isEmpty() || !isMatch(st.pop(), ch)) {
                return false;}
            }
        }
        return st.isEmpty();
    }

    private static boolean isMatch(char open, char close ){
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}