package com.leetcode;


import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/interval-list-intersections/
public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersectedElements = new ArrayList<>();

        int firstIndex = 0;
        int secondIndex = 0;

        while(firstIndex < firstList.length && secondIndex < secondList.length) {
            int[] firstElement = firstList[firstIndex];
            int[] secondElement = secondList[secondIndex];
            int left = Math.max(firstElement[0], secondElement[0]);
            int right = Math.min(firstElement[1], secondElement[1]);
            if(left <= right) {
                intersectedElements.add(new int[]{left, right});
            }
            if(firstElement[1] < secondElement[1]) {
                firstIndex++;
            } else {
                secondIndex++;
            }
        }

        return intersectedElements.toArray(new int[intersectedElements.size()][2]);
    }

    public static void main(String[] args) {
        IntervalListIntersections obj = new IntervalListIntersections();

        int[][] firstList = new int[][]{{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = new int[][]{{1,5},{8,12},{15,24},{25,26}};

        int[][] output = obj.intervalIntersection(firstList, secondList);
        System.out.print("[");
        for(int i = 0; i< output.length; i++) {
            System.out.print("[");
            for(int j = 0; j < output[i].length; j++) {
                System.out.print(output[i][j] + ", ");
            }
            System.out.println("]");
        }

        firstList = new int[][]{{1,3},{5,9}};
        secondList = new int[][]{};

        output = obj.intervalIntersection(firstList, secondList);
        System.out.print("[");
        for(int i = 0; i< output.length; i++) {
            System.out.print("[");
            for(int j = 0; j < output[i].length; j++) {
                System.out.print(output[i][j] + ", ");
            }
            System.out.println("]");
        }

    }
}
