package com.leetcode;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
public class RemoveDuplicateFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int lastValidPointer = 0, currentPointer = 1;

        while(currentPointer < nums.length) {
            if (nums[lastValidPointer] == nums[currentPointer]) {
                currentPointer++;
            }
            else {
                lastValidPointer++;
                nums[lastValidPointer] = nums[currentPointer];
                currentPointer++;
            }
        }

        return lastValidPointer + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicateFromSortedArray obj = new RemoveDuplicateFromSortedArray();
        System.out.println(obj.removeDuplicates(new int[]{1,1,2}));
        System.out.println(obj.removeDuplicates(new int[]{1,2,2,3}));
        System.out.println(obj.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
