package com.practice;

public class RecursionLargestAndSmallest {
    public static void main(String[] args) {
        int a[] = {2, 1,2,3,4,5};
        MinMax minMax = new MinMax();
        minMax.max = a[0];
        minMax.min = a[0];
        minMax = findMinMax(a, a.length);
        System.out.println(minMax);

    }

    static MinMax findMinMax(int []a, int length) {
        if(length == 1) {
            return checkMinMax(a[0], null);
        }
        return checkMinMax(a[length - 1], findMinMax(a, length - 1));
    }



    static MinMax checkMinMax(int a, MinMax minMax) {
        if(minMax == null) {
            minMax = new MinMax();
            minMax.max = a;
            minMax.min = a;
            return minMax;
        }
        if(a < minMax.min) {
            minMax.min = a;
        }
        if(a > minMax.max) {
            minMax.max = a;
        }
        return minMax;
    }

    static class MinMax {
        private int min;
        private int max;

        @Override
        public String toString() {
            return "MinMax{" +
                    "min=" + min +
                    ", max=" + max +
                    '}';
        }
    }
}
