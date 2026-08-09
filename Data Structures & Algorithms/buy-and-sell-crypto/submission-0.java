class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int left = 0;
        int right = 1;
        int maxProfit = 0;
        while(right < len) {
            int currProfit = 0;
            if(prices[right] > prices[left]) {
                currProfit = prices[right] - prices[left];
                maxProfit = Math.max(currProfit, maxProfit);
            } else {
                left = right;// because we have to find only right idx which is min
            } 
            right++;
        }
        return maxProfit;
    }
}
