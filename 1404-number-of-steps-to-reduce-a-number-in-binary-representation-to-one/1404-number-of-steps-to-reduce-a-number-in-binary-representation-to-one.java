class Solution {
   public static int numSteps(String s) {
       int count = 0;
       long decimal = binaryToDecimal(s);
       while(decimal != 1){
           if(decimal % 2 == 0){
               decimal = decimal / 2;
           }
           else{
               decimal = decimal + 1;
           }
           count++;
       }
       return count;
    }

    public static long binaryToDecimal(String s){
        long decimal = 0;
        for(int i = 0; i < s.length(); i++){
            decimal = decimal * 2 + (s.charAt(i) - '0');
        }
        return decimal;
    } 
        
}