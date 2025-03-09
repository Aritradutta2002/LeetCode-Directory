/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        //finding max, min value in the list
        for(ListNode root : lists){
            while(root != null){
                min = Math.min(min, root.val);
                max = Math.max(max, root.val);
                root = root.next;
            }
        }
        //creating a list of size of all unique value
        ListNode[] nodes = new ListNode[max-min+1];

        //list of nodes of same value
        for( ListNode root : lists){
            while( root != null){
                ListNode next = root.next;
                ListNode sameValNode = nodes[root.val - min];
                root.next = sameValNode;
                nodes[root.val - min] = root;
                root = next;
            }
        }
        
        ListNode head = new ListNode(0);
        ListNode cur = head; 

        // Combining the final list
         for (ListNode root : nodes) {
            if (root != null) {
                cur.next = root;
                while (root.next != null) {
                    root = root.next;
                }
                cur = root;
            }
        }


        return head.next;
    }
}