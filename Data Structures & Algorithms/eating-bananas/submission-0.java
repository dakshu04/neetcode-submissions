class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int maxRate = 0;
        for(int num : piles) {
            maxRate = Math.max(maxRate, num);
        }
        int right = maxRate;
        int minRate = 0;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int totalHours = 0;
            for(int num : piles) {
                totalHours += Math.ceil((double)num / mid);
            }
            if(totalHours <= h) {
                // can seracrh for more minRate
                minRate = mid;
                right = mid - 1;
            } else {
                // rate should be inrceased as this would not enough
                left = mid + 1;
            }
        }
        return minRate;
    }
}
