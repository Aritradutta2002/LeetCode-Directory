class Solution {
    private HashSet<String> hs;
    // private void add_binary_codes(String str,int k,String st){
    //     if(st.length()==k){
    //         hs.add(st);
    //         return;
    //     }
    //     add_binary_codes(str,k,st+'0');
    //     add_binary_codes(str,k,st+'1');
    // }
    public boolean hasAllCodes(String s, int k) {
        int n=s.length();
        hs=new HashSet<>();
        // add_binary_codes(s,k,"");
        for(int i=0;i<=n-k;i++){
            String st=s.substring(i,i+k);
            hs.add(st);
        }
        return hs.size()==Math.pow(2,k);
    }
}