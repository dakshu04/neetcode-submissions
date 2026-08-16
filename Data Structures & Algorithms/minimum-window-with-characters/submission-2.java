

class Solution {
    public String minWindow(String s, String t) {
        // Edge case check: return empty string if inputs are null or t is longer than s (impossible to match)
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Left boundary pointer for shrinking the sliding window
        int left = 0;
        
        // Right boundary pointer for expanding the sliding window
        int right = 0;
        
        // Map to store required frequencies for each target character in string t
        Map<Character, Integer> map = new HashMap<>();
        
        // Total count of characters from string t still needed inside the window
        int missingCount = t.length();
        
        // Tracks the smallest valid window length found so far (initialized to infinity)
        int minLen = Integer.MAX_VALUE;
        
        // Stores the starting index in string s of the minimum valid window found
        int startingIdx = 0;

        // Populate frequency map with required character counts from target string t
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Expand the window by moving the right pointer across string s
        while (right < s.length()) {
            // Read the character currently entering the window from the right
            char charRight = s.charAt(right);

            // Process only characters that exist in target string t
            if (map.containsKey(charRight)) {
                // If count is > 0, this character satisfies an unpaid requirement
                if (map.get(charRight) > 0) {
                    missingCount--;
                }
                // Decrement count in map (goes negative if window holds surplus copies of this character)
                map.put(charRight, map.get(charRight) - 1);
            }
            
            // Advance right pointer to officially expand the window range [left, right)
            right++;

            // Shrink window from the left while all characters of t are fully satisfied
            while (missingCount == 0) {
                // Record smaller window length and update starting position if a shorter valid window is found
                if (right - left < minLen) {
                    minLen = right - left;
                    startingIdx = left;
                }

                // Read the character about to be removed from the left edge of the window
                char charAtLeft = s.charAt(left);

                // Check if the exiting character is one of the target characters
                if (map.containsKey(charAtLeft)) {
                    // Restore character demand count back to the map
                    map.put(charAtLeft, map.get(charAtLeft) + 1);
                    
                    // If count becomes > 0, a required character was removed, making the window invalid
                    if (map.get(charAtLeft) > 0) {
                        missingCount++;
                    }
                }
                
                // Move left pointer forward to attempt finding a smaller valid window
                left++;
            }
        }

        // If minLen was updated, extract and return the substring; otherwise, return empty string
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startingIdx, startingIdx + minLen);
    }
}