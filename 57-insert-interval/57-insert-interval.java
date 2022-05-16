class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;

        // add all the intervals in res preceeding newInterval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i++]);
        }

        // merge all overlapping intervals that intersect with newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i++][1], newInterval[1]);
        }
        res.add(newInterval);

        // add all intervals in res succeeding newInterval
        while (i < intervals.length) {
            res.add(intervals[i++]);
        }

        return res.toArray(new int[res.size()][2]);
    }
}
