package com.leetcode;

//https://leetcode.com/problems/trapping-rain-water/description/
//#TwoPointer, #Array, #MonotonicStack
public class TrappingRainWater {
    public int trap(int[] heights) {
        int ans = 0;
        int l = 0, r = heights.length - 1; //left and right pointers
        int lMax = 0, rMax = 0; //left and right max heights
        while(l < r) {
            if (heights[l] < heights[r]) { //move left or right based on which one is smaller
                if (heights[l] >= lMax) {
                    lMax = heights[l];
                } else {
                    //if the current height is smaller than the max height, add the difference to the answer
                    //This is cause the left side is smaller so the water will be trapped by the left side
                    ans += lMax - heights[l];
                }
                l++;
            } else {
                if (heights[r] >= rMax) {
                    rMax = heights[r];
                } else {
                    ans += rMax - heights[r];
                }
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TrappingRainWater obj = new TrappingRainWater();
        System.out.println(obj.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(obj.trap(new int[]{4,2,0,3,2,5}));
    }
}
