package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/intersection-of-two-arrays/
public class IntersectionOfTwoArray {

    public int[] intersect(int[] nums1, int[] nums2) {

        Set<Integer> firstSet = new HashSet<>(nums1.length);
        Set<Integer> secondSet = new HashSet<>(nums2.length);

        for (int i = 0; i < nums1.length; i++) {
            firstSet.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            secondSet.add(nums2[i]);
        }

        List<Integer> intersection = new ArrayList<>();

        for (int element: firstSet) {
            if(secondSet.contains(element)) {
                intersection.add(element);
            }
        }

        return intersection.parallelStream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        IntersectionOfTwoArray obj = new IntersectionOfTwoArray();

        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};

        int[] output = obj.intersect(nums1, nums2);
        for(int element : output) {
            System.out.print(element + ", ");
        }
        System.out.println();

        nums1 = new int[]{4,9,5};
        nums2 = new int[]{9,4,9,8,4};

        output = obj.intersect(nums1, nums2);
        for(int element : output) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }
}
