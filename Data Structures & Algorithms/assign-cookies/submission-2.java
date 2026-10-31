class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int left = 0;
        int right = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(left < g.length && right < s.length) {
            if(g[left] <= s[right]) {
                left++;
            } 
            right++;
        }
        return left;
    }
}