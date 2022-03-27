package com.practice;

public class RecursionLargestAndSecondLargest {
    public static void main(String[] args) {
        int a[] = {2, 1, 2, 3, 4, 6, 0, -1, 10, -2, 4, 3, 5};
        MaxSecondMax minMax = findMaxSecondMax(a, a.length);
        System.out.println(minMax);

    }

    static MaxSecondMax findMaxSecondMax(int[] a, int length) {
        if (length == 1) {
            return checkMaxSecondMAx(a[0], null);
        }
        return checkMaxSecondMAx(a[length - 1], findMaxSecondMax(a, length - 1));
    }


    static MaxSecondMax checkMaxSecondMAx(int a, MaxSecondMax minMax) {
        if (minMax == null) {
            minMax = new MaxSecondMax();
            minMax.max = a;
            minMax.secondMax = a;
            return minMax;
        }
        if (a > minMax.max) {
            minMax.secondMax = minMax.max;
            minMax.max = a;
        } else if (a > minMax.secondMax) {
            minMax.secondMax = a;
        }
        return minMax;
    }

    static class MaxSecondMax {
        private int secondMax;
        private int max;

        @Override
        public String toString() {
            return "MinMax{" +
                    "secondMax=" + secondMax +
                    ", max=" + max +
                    '}';
        }
    }
}
