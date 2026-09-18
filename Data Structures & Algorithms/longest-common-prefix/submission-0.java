class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        Arrays.sort(strs);
        StringBuilder strB = new StringBuilder();
        String first = strs[0];
        String last = strs[n-1];
        for(int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if(first.charAt(i) != last.charAt(i)) {
                return strB.toString();
            } else {
                strB.append(first.charAt(i));
            }
        }
        return strB.toString();
    }
}