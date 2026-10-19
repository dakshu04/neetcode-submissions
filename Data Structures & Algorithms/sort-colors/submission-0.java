class Solution {
    public void sortColors(int[] nums) {
        int[] arr = new int[nums.length];
        int red = 0;
        int white = 0;
        int blue = 0;
        for(int num : nums) {
            if(num == 0) {
                red++;
            } else if(num == 1) {
                white++;
            } else {
                blue++;
            }
        }
        for(int i = 0; i < red; i++) {
            arr[i] = 0;
        }
        for(int i = red; i < red + white; i++) {
            arr[i] = 1;
        }
        for(int i = red + white; i < nums.length; i++) {
            arr[i] = 2;
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
        
    }
}