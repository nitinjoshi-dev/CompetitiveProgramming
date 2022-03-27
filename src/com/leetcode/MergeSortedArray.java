package com.leetcode;


//https://leetcode.com/problems/merge-sorted-array/
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[nums1.length];

        int num1Index = 0;
        int num2Index = 0;
        int ansIndex = 0;

        while (num1Index < m && num2Index < n) {
            int num1 = nums1[num1Index];
            int num2 = nums2[num2Index];
            if (num1 < num2) {
                ans[ansIndex++] = num1;
                num1Index++;
            } else {
                ans[ansIndex++] = num2;
                num2Index++;
            }
        }
        if (num1Index < m) {
            for (; num1Index < m; num1Index++) {
                ans[ansIndex++] = nums1[num1Index];
            }
        } else if (num2Index < n) {
            for (; num2Index < n; num2Index++) {
                ans[ansIndex++] = nums2[num2Index];
            }
        }

        for(int i = 0; i < ans.length; i++) {
            nums1[i] = ans[i];
        }
    }

    public static void main(String[] args) {
        MergeSortedArray obj = new MergeSortedArray();

        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;

        obj.merge(nums1, m, nums2, n);
        for(int element : nums1) {
            System.out.print(element + ", ");
        }
        System.out.println();

        nums1 = new int[]{1};
        m = 1;
        nums2 = new int[]{};
        n = 0;

        obj.merge(nums1, m, nums2, n);
        for(int element : nums1) {
            System.out.print(element + ", ");
        }
        System.out.println();

        nums1 = new int[]{0};
        m = 0;
        nums2 = new int[]{1};
        n = 1;

        obj.merge(nums1, m, nums2, n);
        for(int element : nums1) {
            System.out.print(element + ", ");
        }
        System.out.println();

    }
}
