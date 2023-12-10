package com.leetcode;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
public class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int min = Math.min(nums[0], nums[nums.length - 1]);
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = (r + l) / 2;
            min = Math.min(min, nums[mid]);
            if(nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        FindMinInRotatedSortedArray obj = new FindMinInRotatedSortedArray();
        int [] nums = new int[]{0,1,2,3,4,5,6};
        int min = obj.findMin(nums);
        System.out.println("min " + min);

        nums = new int[]{3,4,5,1,2};
        min = obj.findMin(nums);
        System.out.println("min " + min);

        nums = new int[]{4,5,6,7,0,1,2};
        min = obj.findMin(nums);
        System.out.println("min " + min);

        nums = new int[]{11,13,15,17};
        min = obj.findMin(nums);
        System.out.println("min " + min);

        nums = new int[]{13,15,17, 11};
        min = obj.findMin(nums);
        System.out.println("min " + min);

        nums = new int[]{-13,-11,-17,-15};
        min = obj.findMin(nums);
        System.out.println("min " + min);
    }
}
