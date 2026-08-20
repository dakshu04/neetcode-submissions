class Solution {
    // Helper method to find the end node of the first half
    public ListNode findHalf(ListNode root) {
        ListNode slow = root;
        ListNode fast = root;
        // IMPORTANT: Check fast.next != null FIRST to avoid NullPointerException before fast.next.next
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // Returns the middle node (end of the first half)
    }

    // Standard helper method to reverse a linked list
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev; // Returns the new head of the reversed second half
    }

    public void reorderList(ListNode head) {
        // Base case: Lists with 0, 1, or 2 nodes require no reordering
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        // Step 1: Find the middle node
        ListNode mid = findHalf(head);

        // Step 2: Separate second half from first half
        ListNode secondHalf = mid.next; 
        mid.next = null; // CRITICAL: Sever the link to prevent infinite cycles during merge

        // Step 3: Reverse the second half
        ListNode second = reverse(secondHalf);
        ListNode first = head;

        // Step 4: Interleave/merge the two split lists
        while (second != null) {
            // Save next pointers so we don't lose rest of lists
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            // Connect node from first half to node from second half
            first.next = second;
            // Connect node from second half back to rest of first half
            second.next = temp1;

            // Move pointers forward for the next iteration
            first = temp1;
            second = temp2;
        }
    }
}