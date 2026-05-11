class Solution {
    public static int[] separateDigits(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int i : nums) {
            ans.addAll(addToArray(i));
        }
        int[] arr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }

    public static List<Integer> addToArray(int num) {
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            int digit = num % 10;
            list.add(digit);
            num /= 10;
        }
        Collections.reverse(list);
        return list;
    }
}