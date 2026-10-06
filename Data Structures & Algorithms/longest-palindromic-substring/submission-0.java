class Solution {
    public int expandAroundCenter(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return (end - 1) - (start + 1) + 1;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0;
        int start = 0; // start would be zero as we are considering the largest palindrome substring
        for(int i = 0; i < n; i++) {
            int length1 = expandAroundCenter(s, i, i); // odd length
            int length2 = expandAroundCenter(s, i, i + 1); // even length
            int length = Math.max(length1, length2);
            if(length > maxLen) {
                maxLen = length;
                start = i - (length - 1) / 2; //starting idx // 1 - (3-1)/2 = 0
            }
        }
        return s.substring(start, start + maxLen);
    }
}