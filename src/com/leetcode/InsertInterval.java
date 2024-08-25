package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        boolean notAdded = true;
        int i = 0;
        while (i < intervals.length) {
            if (intervals[i][0] < newInterval[0] && notAdded) {
                if (intervals[i][1] > newInterval[0]) {
                    int k = i;
                    while (i < intervals.length) {
                        if (intervals[k][1] <= newInterval[1]
                                && (i == intervals.length - 1 || intervals[i + 1][0] > newInterval[1])) {
                            result.add(new int[] { intervals[k][0], Math.max(newInterval[1], intervals[i][1])});
                            notAdded = false;
                            i++;
                            break;
                        } else {
                            i++;
                        }
                    }
                } else {
                    result.add(intervals[i++]);
                }
            } else if (intervals[i][0] > newInterval[0] && notAdded) {
                if (newInterval[1] > intervals[i][0]) {
                    while (i < intervals.length) {
                        if (i == intervals.length - 1  ||
                                intervals[i + 1][0] > newInterval[1]) {
                            result.add(new int[] { newInterval[0], Math.max(newInterval[1], intervals[i][1])});
                            i++;
                            break;
                        } else {
                            i++;
                        }
                    }
                } else {
                    result.add(new int[] { newInterval[0], newInterval[1] });
                }
                notAdded = false;
            } else if (notAdded && i == intervals.length - 1) {
                result.add(new int[] { newInterval[0], newInterval[1] });
                notAdded = false;
            } else {
                result.add(intervals[i++]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
    
        // Add all intervals ending before newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
    
        // Merge all overlapping intervals
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
    
        // Add all intervals starting after newInterval ends
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }
    
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        InsertInterval obj = new InsertInterval();
        int[][] nums = new int[][] { { 1, 3 }, { 6, 9 } };
        int[][] ans = obj.insert(nums, new int[] { 2, 5 });
        printAns(ans);

        nums = new int[][] { { 1, 2 }, { 6, 9 } };
        ans = obj.insert(nums, new int[] { 3, 5 });
        printAns(ans);

        nums = new int[][] { { 3, 5 }, { 6, 9 } };
        ans = obj.insert(nums, new int[] { 1, 2 });
        printAns(ans);

        nums = new int[][] { { 3, 5 }, { 6, 9 } };
        ans = obj.insert(nums, new int[] { 1, 4 });
        printAns(ans);

        nums = new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        ans = obj.insert(nums, new int[] { 4, 8 });
        printAns(ans);

        nums = new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 } };
        ans = obj.insert(nums, new int[] { 4, 6 });
        printAns(ans);

        nums = new int[][] { { 3, 5 }, { 6, 7 } };
        ans = obj.insert(nums, new int[] { 1, 6 });
        printAns(ans);

        nums = new int[][] { { 3, 5 }, {6,7}, { 8, 10 } };
        ans = obj.insert(nums, new int[] { 1, 6 });
        printAns(ans);

        nums = new int[][] { { 3, 5 }, { 8, 10 } };
        ans = obj.insert(nums, new int[] { 6, 9 });
        printAns(ans);

        nums = new int[][] { { 3, 5 }, {6, 9}, { 15, 20 } };
        ans = obj.insert(nums, new int[] { 11, 21 });
        printAns(ans);
    }

    private static void printAns(int[][] ans) {
        System.out.println("======================");
        for (int[] a : ans) {
            System.out.println(a[0] + ", " + a[1]);
        }
    }
}