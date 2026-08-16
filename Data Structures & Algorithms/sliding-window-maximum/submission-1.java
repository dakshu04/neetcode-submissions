public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        
        // Total windows of size k in an array of size n is always (n - k + 1)
        int[] output = new int[n - k + 1];
        
        // Deque (double-ended queue) to store INDEXES of numbers in nums.
        // We keep elements inside 'q' sorted in descending order (biggest number's index at the front).
        Deque<Integer> q = new LinkedList<>();
        
        // 'l' is the left boundary (start) of our window
        // 'r' is the right boundary (end) of our window
        int l = 0, r = 0;

        while (r < n) {
            // STEP 1: KICK OUT SMALLER NUMBERS FROM THE BACK
            // Before adding the new number nums[r], kick out any index from the back of the queue 
            // whose value is smaller than nums[r]. A smaller number that appears EARLIER 
            // will never be the maximum again, because nums[r] is larger and will outlast it.
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }
            
            // Add current element's index to the back of the queue
            q.addLast(r);

            // STEP 2: REMOVE EXPIRED INDEXES FROM THE FRONT
            // If the biggest element in our queue (at the front) falls outside our left window boundary 'l',
            // it means it has slid out of view and must be removed.
            if (l > q.getFirst()) {
                q.removeFirst();
            }

            // STEP 3: RECORD THE MAXIMUM FOR THE CURRENT WINDOW
            // Once the right pointer 'r' has expanded far enough to form a valid window of size 'k' (r + 1 >= k),
            // the front of the queue is guaranteed to be the maximum value in this window.
            if ((r + 1) >= k) {
                output[l] = nums[q.getFirst()]; // Save the max value
                l++;                            // Move the left window boundary forward
            }
            
            r++; // Expand the right window boundary forward
        }

        return output;
    }
}