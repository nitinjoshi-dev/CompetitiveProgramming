package com.leetcode;

//https://leetcode.com/problems/remove-element/
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int lastValidPointer = 0, currentPointer = 0;

        while(currentPointer < nums.length) {
            if (nums[currentPointer] == val) {
                currentPointer++;
            }
            else {
                nums[lastValidPointer] = nums[currentPointer];
                currentPointer++;
                lastValidPointer++;
            }
        }

        return lastValidPointer;
    }

    public static void main(String[] args) {
        RemoveElement obj = new RemoveElement();
        System.out.println(obj.removeElement(new int[]{3, 2, 2, 3, 4, 5}, 3));
        System.out.println(obj.removeElement(new int[]{2, 2, 3, 4, 5}, 3));
        System.out.println(obj.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
}
