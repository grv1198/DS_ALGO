package com.grv.intervals;

import java.util.Arrays;

public class EraseOverlappingInterval {
    public int eraseOverlapIntervals(int[][] intervals) {


        Arrays.sort(intervals, (i1, i2) -> ((Integer)i1[0]).compareTo((Integer)i2[0]));

        int count = 0;
        // 1,2 ,,, 1,3,,,2,3,,,3,4

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i-1][1]) {
                intervals[i][1] = Math.min(intervals[i][1], intervals[i-1][1]);
                count++;
            }
        }

        return count;
    }
}
