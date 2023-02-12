package com.practice.binarysearch;

public class BinarySearchExample {

    public static void main(String[] args) {
        BinarySearchExample binarySearchExample = new BinarySearchExample();
        int[] elements = {1,2,3,4,5,6};
        int elementToSearch = 3;
        int index = binarySearchExample.search(elements, 0, elements.length - 1, elementToSearch);
        System.out.println("Element " + elementToSearch + " is in index " + index);

        elementToSearch = 6;
        index = binarySearchExample.search(elements, 0, elements.length - 1, elementToSearch);
        System.out.println("Element " + elementToSearch + " is in index " + index);

        elementToSearch = 1;
        index = binarySearchExample.search(elements, 0, elements.length - 1, elementToSearch);
        System.out.println("Element " + elementToSearch + " is in index " + index);

        elementToSearch = 10;
        index = binarySearchExample.search(elements, 0, elements.length - 1, elementToSearch);
        System.out.println("Element " + elementToSearch + " is in index " + index);
    }

    private int search(int[] elements, int start, int end, int elementToSearch) {
        int mid = (start + end) / 2;
        int element = elements[mid];
        if (start > end) {
            return -1;
        }
        if(element == elementToSearch) {
            return mid;
        } else if (element > elementToSearch) {
            return search(elements, start, mid - 1, elementToSearch);
        } else {
            return search(elements, mid + 1, end, elementToSearch);
        }
    }
}
