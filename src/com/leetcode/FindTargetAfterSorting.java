package com.leetcode;

import com.practice.binarysearch.BinarySearchExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/find-target-indices-after-sorting-array/
public class FindTargetAfterSorting {

    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> indicesList = new ArrayList<>();
        Arrays.sort(nums);

        search(nums, 0, nums.length - 1, target, indicesList);
        Collections.sort(indicesList);
        return indicesList;
    }

    public List<Integer> targetIndicesBetterSolution(int[] nums, int target) {
        int count = 0, lessThan = 0;
        for (int n : nums) {
            if (n == target) count++;
            if (n < target) lessThan++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(lessThan++);
        }
        return result;
    }

    public static void main(String[] args) {
        FindTargetAfterSorting findTargetAfterSorting = new FindTargetAfterSorting();
        int[] elements = {1,2,3,4,5,6};
        int elementToSearch = 3;
        List<Integer> indicesList = findTargetAfterSorting.targetIndicesBetterSolution(elements, elementToSearch);
        System.out.println("Indices are");
        indicesList.forEach(index -> {
            System.out.print(index + "\t");
        });
        System.out.println();
        int[] elements2 = {1,3,3,3,3,6};
        elementToSearch = 3;
        indicesList = findTargetAfterSorting.targetIndicesBetterSolution(elements2, elementToSearch);
        System.out.println("Indices are");
        indicesList.forEach(index -> {
            System.out.print(index + "\t");
        });
        System.out.println();
        elementToSearch = 1;
        indicesList = findTargetAfterSorting.targetIndicesBetterSolution(elements2, elementToSearch);
        System.out.println("Indices are");
        indicesList.forEach(index -> {
            System.out.print(index + "\t");
        });
        System.out.println();
        elementToSearch = 10;
        indicesList = findTargetAfterSorting.targetIndicesBetterSolution(elements2, elementToSearch);
        System.out.println("Indices are");
        indicesList.forEach(index -> {
            System.out.print(index + "\t");
        });
        System.out.println();
        elementToSearch = 6;
        indicesList = findTargetAfterSorting.targetIndicesBetterSolution(elements2, elementToSearch);
        System.out.println("Indices are");
        indicesList.forEach(index -> {
            System.out.print(index + "\t");
        });
        System.out.println();
    }

    private List<Integer> search(int[] elements, int start, int end, int elementToSearch) {
        List<Integer> indicesList = new ArrayList<>();

        while(start <= end) {
            int mid = (start + end) / 2;
            int element = elements[mid];
            if(element == elementToSearch) {
                indicesList.add(mid);
            } else if (element > elementToSearch) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return indicesList;
    }

    private void search(int[] elements, int start, int end, int elementToSearch, List<Integer> indicesList) {
        int mid = (start + end) / 2;
        int element = elements[mid];
        if (start > end) {
            return;
        }
        if(element == elementToSearch) {
            indicesList.add(mid);
            search(elements, start, mid - 1, elementToSearch, indicesList);
            search(elements, mid + 1, end, elementToSearch, indicesList);
        } else if (element > elementToSearch) {
            search(elements, start, mid - 1, elementToSearch, indicesList);
        } else {
            search(elements, mid + 1, end, elementToSearch, indicesList);
        }
    }
}
