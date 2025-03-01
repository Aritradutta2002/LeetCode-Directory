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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = returnValue(l1);
        int num2 = returnValue(l2);

        int num = num1 + num2; // No need to reverse digits

        return buildListNode(num);
    }

    public ListNode buildListNode(int num) {
        if (num == 0) return new ListNode(0);

        ListNode root = null;
        ListNode prev = null;

        while (num != 0) {
            int val = num % 10;
            ListNode newNode = new ListNode(val);

            if (root == null) {
                root = newNode; 
            } else {
                prev.next = newNode; 
            }

            prev = newNode; 
            num /= 10;
        }

        return root;
    }

    int returnValue(ListNode root) {
        int num = 0;
        int place = 1;

        while (root != null) {
            num += root.val * place;
            root = root.next;
            place *= 10;
        }

        return num;
    }
}
