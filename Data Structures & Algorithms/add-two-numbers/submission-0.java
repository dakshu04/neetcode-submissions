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
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carry = 0;
        int totalSum = 0;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(temp1 != null || temp2 != null || carry != 0) {
            int x = temp1 != null ? temp1.val : 0;
            int y = temp2 != null ? temp2.val : 0;
            totalSum = x + y + carry;
            carry = totalSum / 10;
            int digit = totalSum % 10;
            curr.next = new ListNode(digit);
            curr = curr.next;
            if(temp1 != null) temp1 = temp1.next;
            if(temp2 != null) temp2 = temp2.next;
        }
        return dummy.next;
    }
}
