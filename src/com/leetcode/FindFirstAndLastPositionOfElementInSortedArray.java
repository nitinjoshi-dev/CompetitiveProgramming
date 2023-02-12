package com.leetcode;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = 0;
        result[1] = nums.length - 1;
        search(nums, 0, nums.length - 1, target, result);

        return result;
    }

    private void search(int[] elements, int start, int end, int elementToSearch, int[] indicesList) {
        int mid = (start + end) / 2;
        int element = elements[mid];
        if (start > end) {
            return;
        }
        if(element == elementToSearch) {
            if(indicesList[1] < mid)
                indicesList[1] = mid;
            else if (mid < indicesList[0]) {

            }
            search(elements, start, mid - 1, elementToSearch, indicesList);
            search(elements, mid + 1, end, elementToSearch, indicesList);
        } else if (element > elementToSearch) {
            search(elements, start, mid - 1, elementToSearch, indicesList);
        } else {
            search(elements, mid + 1, end, elementToSearch, indicesList);
        }
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray findTargetAfterSorting = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] elements = {1,2,3,4,5,6};
        int elementToSearch = 3;
        int[] indicesList = findTargetAfterSorting.searchRange(elements, elementToSearch);
        System.out.println("Indices are");
        for (int index : indicesList) {
            System.out.print(index + "\t");
        }
        System.out.println();
        int[] elements2 = {1,3,3,3,3,6};
        elementToSearch = 3;
        indicesList = findTargetAfterSorting.searchRange(elements2, elementToSearch);
        System.out.println("Indices are");
        for (int index : indicesList) {
            System.out.print(index + "\t");
        }
        System.out.println();
        elementToSearch = 1;
        indicesList = findTargetAfterSorting.searchRange(elements2, elementToSearch);
        System.out.println("Indices are");
        for (int index : indicesList) {
            System.out.print(index + "\t");
        }
        System.out.println();
        elementToSearch = 10;
        indicesList = findTargetAfterSorting.searchRange(elements2, elementToSearch);
        System.out.println("Indices are");
        for (int index : indicesList) {
            System.out.print(index + "\t");
        }
        System.out.println();
        elementToSearch = 6;
        indicesList = findTargetAfterSorting.searchRange(elements2, elementToSearch);
        System.out.println("Indices are");
        for (int index : indicesList) {
            System.out.print(index + "\t");
        }
        System.out.println();
    }


}
