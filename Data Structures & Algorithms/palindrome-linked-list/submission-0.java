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
    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode findHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode findHalf = findHalf(head);
        ListNode curr1 = head;
        ListNode curr2 = findHalf;
        ListNode reverseCurr = reverse(curr2);
        while(curr1 != null && reverseCurr != null) {
            if(curr1.val != reverseCurr.val) {
                return false;
            }
            curr1 = curr1.next;
            reverseCurr = reverseCurr.next;
        }
        return true;
    }
}