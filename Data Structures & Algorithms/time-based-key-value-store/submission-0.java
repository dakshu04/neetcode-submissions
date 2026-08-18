class TimeMap {
    public class Data {
        String value;
        int timestamp;

        Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private Map<String, List<Data>> map; // Fixed key type from Integer to String

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>()); // Create list only if key doesn't exist
        map.get(key).add(new Data(value, timestamp)); // Use .add() instead of .put()
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Data> list = map.get(key);
        int low = 0, high = list.size() - 1;
        String result = "";

        // Binary search to find the largest timestamp <= target timestamp
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                result = list.get(mid).value; // Valid timestamp found, save candidate
                low = mid + 1;                 // Move right to see if a larger valid timestamp exists
            } else {
                high = mid - 1;                // Move left if timestamp is strictly > target
            }
        }

        return result;
    }
}