class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : stones) {
            maxHeap.add(num);
        }
        while(maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            if(first != second) {
                maxHeap.add(first - second);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
