/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return true;
        }
        Collections.sort((intervals) , (a, b) -> a.start - b.start);
        int previousStart = intervals.get(0).start;
        int previousEnd = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); i++) {
            int currentStart = intervals.get(i).start;
            int currentEnd = intervals.get(i).end;
            if(currentStart < previousEnd) {
                return false;
            }
            previousStart = currentStart;
            previousEnd = currentEnd;
        }
        return true;
    }
}
