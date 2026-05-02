class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(titleToNumber(str));
    }

    public static int titleToNumber(String columnTitle) {
        int ans = 0;
        for (char c : columnTitle.toCharArray()) {
            ans = ans * 26 + (c - 'A') + 1;
        }
        return ans;
    }
}