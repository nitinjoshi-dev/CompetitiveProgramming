package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//https://leetcode.com/problems/intersection-of-two-arrays-ii/
public class IntersectionOfTwoArray2 {

    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Long> firstMapCount = Arrays
                .stream(nums1)
                .boxed()
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()));

        List<Integer> intersection = new ArrayList<>();

        Arrays.stream(nums2)
                .boxed()
                .forEach(element -> {
                    Long count = firstMapCount.get(element);
                    if(count != null && count > 0) {
                        firstMapCount.put(element, count - 1);
                        intersection.add(element);
                    }
                });

        return intersection.parallelStream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        IntersectionOfTwoArray2 obj = new IntersectionOfTwoArray2();

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
