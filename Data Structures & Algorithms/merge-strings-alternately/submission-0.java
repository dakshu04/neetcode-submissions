class Solution {
    public String mergeAlternately(String word1, String word2) {
        int left = 0;
        int right = 0;
        StringBuilder ans = new StringBuilder();
        while(left < word1.length() && right  < word2.length()) {
            ans.append(word1.charAt(left++));
            ans.append(word2.charAt(right++));
        }
        while(left < word1.length()) {
            ans.append(word1.charAt(left++));
        }
        while(right < word2.length()) {
            ans.append(word2.charAt(right++));
        }
        return ans.toString();
    }
}