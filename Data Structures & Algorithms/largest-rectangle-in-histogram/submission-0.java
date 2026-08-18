class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftSmallerEl = new int[n];
        leftSmallFn(heights, leftSmallerEl, n);
        int[] rightSmallerEl = new int[n];
        rightSmallerFn(heights, rightSmallerEl, n);
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, (rightSmallerEl[i] - leftSmallerEl[i] - 1) * heights[i]);
        }
        return maxArea;
    }
    public void leftSmallFn(int[] heights, int[] leftSmallerEle, int n) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                leftSmallerEle[i] = -1;
            } else {
                leftSmallerEle[i] = stack.peek();
            }
            stack.push(i);
        }
    }
    public void rightSmallerFn(int[] heights, int[] rightSmallerEle, int n) {
        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                rightSmallerEle[i] = n;
            } else {
                rightSmallerEle[i] = stack.peek();
            }
            stack.push(i);
        }
    }
}