class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );
        for(int num : map.keySet()) {
            minHeap.add(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] arr = new int[k];
        for(int i = 0; i < k; i++) {
            arr[i] = minHeap.poll();
        }
        return arr;
    }
}
