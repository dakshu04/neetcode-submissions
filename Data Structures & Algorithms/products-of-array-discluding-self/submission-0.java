class Solution {
    public int[] productExceptSelf(int[] nums) {
        int allProd = 1;
        int zeroCount = 0;
        int[] arr = new int[nums.length];
        for(int num : nums) {
            if(num == 0) {
                zeroCount++;
            } else {
                allProd *= num;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(zeroCount > 1) {
                arr[i] = 0;
            } else if(zeroCount == 1) {
                arr[i] = (nums[i] == 0) ? allProd: 0; 
            } else {
                arr[i] = allProd / nums[i];
            }
        }
        return arr;
    }
}  
