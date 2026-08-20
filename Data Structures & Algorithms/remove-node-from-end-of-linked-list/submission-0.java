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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        temp = head;
        if(size == n) return temp.next;
        int target = size - n;
        for(int i = 1; i < target; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}
