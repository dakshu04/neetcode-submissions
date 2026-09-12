class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int idx = 0;
        for(int num : nums) {
            if(num != val) {
                nums[idx++] = num;
                count++;
            }
        }
        return count;
    }
}