class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[start] <= nums[mid]) { // left sorted
                min = Math.min(nums[start], min);
                start = mid + 1;
            } else { // right is sorted
                min = Math.min(nums[mid], end);
                end = mid - 1;
            }
        }
        return min;
    }
}