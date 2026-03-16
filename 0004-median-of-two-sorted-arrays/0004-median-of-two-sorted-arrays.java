class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int l1 = 0;
        int l2 = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;

        while(l1 < n1 && l2 < n2){
            if(nums1[l1] < nums2[l2]){
                list.add(nums1[l1]);
                l1++;
            }else{
                list.add(nums2[l2]);
                l2++;
            }
        }

        while(l1 < n1){
            list.add(nums1[l1++]);
        }

        while(l2 < n2){
            list.add(nums2[l2++]);
        }
        int mid = list.size() / 2;
        if((list.size() & 1) != 0){
            return (double) list.get(mid);
        } else{
            return (double) (list.get(mid - 1) + list.get(mid)) / 2;
        }
    }
}