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

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(ListNode root : lists){
            while(root != null){
                max = Math.max(max, root.val);
                min = Math.min(min, root.val);
                root = root.next;
            }
        }

        ListNode[] node = new ListNode[max - min + 1];

        for(var root : lists){
            while( root != null){
                ListNode next = root.next;
                ListNode sameValue = node[root.val - min];
                root.next = sameValue;
                node[root.val - min] = root;
                root = next;
            }
        }

        ListNode head = new ListNode(0);
        ListNode curr = head;

        for(var root : node){
            if(root != null){
                curr.next = root;
                while(root.next != null){
                    root = root.next;
                }
                curr = root;
            }
        }
        return head.next;
    }
}
