package com.leetcode;

import java.util.*;

//https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        List<int[]> answer = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i + 1][0] <= right) {
                right = right > intervals[i + 1][1] ? right : intervals[i + 1][1];
            } else {
                int[] intervalPair = new int[2];
                intervalPair[0] = left;
                intervalPair[1] = right;
                answer.add(intervalPair);
                left = intervals[i + 1][0];
                right = intervals[i + 1][1];
            }
        }
        int[] intervalPair = new int[2];
        intervalPair[0] = left;
        intervalPair[1] = right;
        answer.add(intervalPair);

        return answer.toArray(new int[answer.size()][]);
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {

        MergeIntervals object = new MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] answer = object.merge(intervals);
        System.out.println(Arrays.deepToString(answer));

        int[][] intervals1 = {{1, 4}, {4, 5}};
        answer = object.merge(intervals1);
        System.out.println(Arrays.deepToString(answer));

        int[][] intervals2 = {{1, 4}, {8, 9}};
        answer = object.merge(intervals2);
        System.out.println(Arrays.deepToString(answer));

        int[][] intervals3 = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        answer = object.merge(intervals3);
        System.out.println(Arrays.deepToString(answer));

        int[][] intervals4 = {{1, 3}, {1, 3}};
        answer = object.merge(intervals4);
        System.out.println(Arrays.deepToString(answer));

        int[][] intervals5 = {{1, 4}, {2, 3}};
        answer = object.merge(intervals5);
        System.out.println(Arrays.deepToString(answer));

        int[][] intervals6 = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        answer = object.merge(intervals6);
        System.out.println(Arrays.deepToString(answer));


    }


}
