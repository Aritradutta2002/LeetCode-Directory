class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            ListNode temp  = lists[i];
            while(temp !=null){
                list.add(temp.val);
                temp = temp.next;
            }
        }
        Collections.sort(list);
        
        ListNode dommy = new ListNode(-1);
        ListNode temp = dommy;

        for(int num:list){
            ListNode newNode = new ListNode(num);
            temp.next = newNode;
            temp = temp.next;
        }
        return dommy.next;
    }
}