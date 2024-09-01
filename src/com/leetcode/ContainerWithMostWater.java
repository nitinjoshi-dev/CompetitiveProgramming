package com.leetcode;

//https://leetcode.com/problems/container-with-most-water/
//#TwoPointer
public class ContainerWithMostWater {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int l = 0, r = heights.length - 1;
        while (l < r) {
            if (heights[l] < heights[r]) {
                maxArea = Math.max(maxArea, (r - l) * heights[l]);
                l++;
            }
            else {
                maxArea = Math.max(maxArea, (r - l) * heights[r]);
                r--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();
        int [] height = new int[]{1,8,6,2,5,4,8,3,7};
        int maxArea = obj.maxArea(height);
        System.out.println("maxArea " + maxArea);

        height = new int[]{1,1};
        maxArea = obj.maxArea(height);
        System.out.println("maxArea " + maxArea);
    }
}
