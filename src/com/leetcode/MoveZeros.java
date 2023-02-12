package com.leetcode;

//https://leetcode.com/problems/move-zeroes/
public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int[] positionToShiftFrom = new int[nums.length];
        int maxShift = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                positionToShiftFrom[maxShift++] = i;
            }
        }

        for (int i = 0; i < positionToShiftFrom.length; i++) {
            nums[i] = nums[positionToShiftFrom[i]];
        }

        for (int i = maxShift; i< nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeros obj = new MoveZeros();

        int[] nums = {0,1,0,3,12};
        obj.moveZeroes(nums);
        printResult(nums);

        int[] nums1 = {0};
        obj.moveZeroes(nums1);
        printResult(nums1);

        int[] nums2 = {4,2,4,0,0,3,0,5,1,0};
        obj.moveZeroes(nums2);
        printResult(nums2);
    }


    private static void printResult(int[] result) {
        for (int digit : result) {
            System.out.print(digit + ", ");
        }
        System.out.println();
        System.out.println("----------------");
    }

}
