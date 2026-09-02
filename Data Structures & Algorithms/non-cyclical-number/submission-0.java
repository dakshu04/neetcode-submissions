class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n)) {
            set.add(n);
            n = getSelfSquare(n);
            if(n == 1) {
                return true;
            }
        }
        return false;
    }
    public int getSelfSquare(int n) {
        int output = 0;
        while(n > 0) {
            int digit = n % 10;
            output += digit * digit;
            n = n / 10;
        }
        return output;
    }
}