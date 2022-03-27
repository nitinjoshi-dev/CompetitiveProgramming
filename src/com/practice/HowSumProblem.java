package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Given an integer s and array a of size n
 * Output what elements can be added to give the sum as s.
 * if not possible return not possible
 */
public class HowSumProblem {

    static int i = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int s = scanner.nextInt();
        int n = scanner.nextInt();
        int[] elements = new int[n];


        for (int i = 0; i < n; i++) {
            elements[i] = scanner.nextInt();

        }

        Long startTime = System.nanoTime();

        List<Integer> result = howSumRecursion(s, elements, n);
        System.out.println(System.nanoTime() - startTime);
        if (result == null) {
            System.out.println("Not possible");
        } else {
            for (int element : result) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }

    private static List<Integer> howSumRecursion(int s, int[] elements, int n) {
        if (s == 0) {
            return new ArrayList<>(elements.length);
        }
        if (s < 0 || n == 0) {
            return null;
        }
        List<Integer> result = howSumRecursion(s - elements[n-1], elements, n);
        if (result == null) {
            result = howSumRecursion(s, elements, n - 1);
            return result;
        } else {
            result.add(elements[n-1]);
            return result;
        }
    }
}
