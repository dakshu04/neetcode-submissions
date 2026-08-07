class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        for(int num : set) {
            if(!set.contains(num - 1)) {
                int len = 1;
                int currNum = num;
                while(set.contains(currNum + 1)) {
                    currNum++;
                    len++;
                }
            maxLen = Math.max(len, maxLen);
            }
        }
        return maxLen;
    }
}
