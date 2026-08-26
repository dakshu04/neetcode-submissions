class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> {
                int distA = a[0] * a[0] + a[1] * a[1];
                int distB = b[0] * b[0] + b[1] * b[1];

                return distB - distA;
            }
        );
        for(int[] point : points) {
            maxHeap.add(point);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++) {
            ans[i] = maxHeap.poll();
        }
        return ans;
    }
}
