class Solution {
    public boolean isPalindrom(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return isPalindrom(s, start + 1, end) || isPalindrom(s, start, end - 1);
            }
            start++;
            end--;
        }
        return true;
    }
}