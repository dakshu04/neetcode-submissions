class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Base case: If s1 is longer than s2, s2 cannot contain a permutation of s1
    //     if (s1.length() > s2.length()) {
    //         return false;
    //     }

    //     // Frequency maps for s1 and the current sliding window of s2
    //     // Size 26 handles lowercase English letters ('a' through 'z')
    //     int[] s1Map = new int[26];
    //     int[] s2Map = new int[26];

    //     // Initialize frequency maps for s1 and the initial window of s2 (length = s1.length())
    //     for (int i = 0; i < s1.length(); i++) {
    //         s1Map[s1.charAt(i) - 'a']++;
    //         s2Map[s2.charAt(i) - 'a']++;
    //     }

    //     // Slide the window through s2, stopping before the last window position
    //     for (int i = 0; i < s2.length() - s1.length(); i++) {
    //         // Check if the current window is a permutation (character counts match)
    //         if (matches(s1Map, s2Map)) {
    //             return true;
    //         }
            
    //         // Slide window to the right:
    //         // 1. Add character coming into the window (right end)
    //         s2Map[s2.charAt(i + s1.length()) - 'a']++;
    //         // 2. Remove character leaving the window (left end)
    //         s2Map[s2.charAt(i) - 'a']--;
    //     }

    //     // Check frequency match for the final window position
    //     return matches(s1Map, s2Map);
    // }

    // // Helper function to compare frequency count arrays of length 26
    // private boolean matches(int[] s1Map, int[] s2Map) {
    //     for (int i = 0; i < 26; i++) {
    //         if (s1Map[i] != s2Map[i]) {
    //             return false; // Mismatch found
    //         }
    //     }
    //     return true; // All character frequencies match


    // using HashMap
    if (s1.length() > s2.length()) return false;
    HashMap<Character, Integer> map = new HashMap<>();
    HashMap<Character, Integer> windowMap = new HashMap<>();
    for(int i = 0; i < s1.length(); i++) {
        map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
    }
    for(int i = 0; i < s1.length(); i++) {
        windowMap.put(s2.charAt(i), windowMap.getOrDefault(s2.charAt(i), 0) + 1);
    }
    if(map.equals(windowMap)) return true;
    int windowSize = s1.length();
    for(int i = windowSize; i < s2.length(); i++) {
        windowMap.put(s2.charAt(i), windowMap.getOrDefault(s2.charAt(i), 0) + 1);
        char removeChar = s2.charAt(i - windowSize);
        if(windowMap.get(removeChar) == 1) {
            windowMap.remove(removeChar);
        } else {
            windowMap.put(removeChar, windowMap.get(removeChar) - 1);
        }
        if(map.equals(windowMap)) {
            return true;
        }
    }
    return false;
    }
}