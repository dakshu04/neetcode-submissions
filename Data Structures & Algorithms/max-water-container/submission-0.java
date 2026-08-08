class Solution {
    public int maxArea(int[] heights) {
        int start = 0;
        int end = heights.length - 1;
        int maxArea = 0;
        while(start < end) {
            int currArea = (end - start) * Math.min(heights[end], heights[start]);
            maxArea = Math.max(currArea, maxArea);
            if(heights[end] > heights[start]) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }
}
