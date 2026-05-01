class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> list = new ArrayList<>();
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    minimum = Math.min(minimum, i + j);
                }
            }
        }
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j]) && (i + j) <= minimum) {
                    list.add(list1[i]);
                }
            }
        }
        return list.toArray(new String[0]);
    }
}