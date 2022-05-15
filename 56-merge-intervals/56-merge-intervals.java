class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Compare());

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] prevInterval = list.get(list.size() - 1);
            int[] currInterval = intervals[i];
            // now we need to check, if currInterval can be merged with prev interval
            if (currInterval[0] <= prevInterval[1]) {
                // we can merge
                int newEnd = Math.max(prevInterval[1], currInterval[1]);
                prevInterval[1] = newEnd;
            } else {
                list.add(currInterval);
            }
        }
        int[][] res = new int[list.size()][2];
        int i = 0;
        for (int[] interval : list) {
            res[i++] = interval;
        }
        return res;
    }

    static class Compare implements Comparator<int[]> {

        public int compare(int[] a, int[] b) {
            return Integer.compare(a[0], b[0]);
        }
    }
}
