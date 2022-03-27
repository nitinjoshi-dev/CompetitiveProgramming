package com.practice;

import java.util.Scanner;

/**
 * There is a matrix with 2 rows and n columns
 * Input is given as n, the columns of matrix
 * The sum of all elements in first row, u and sum of all elements in second row l
 * Array c of size n specifying the sum of elements in each column
 */
public class MatrixGeneration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int u = scanner.nextInt();
        int l = scanner.nextInt();

        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }

        int [][] matrix = findMatrix(n, u, l, c);
        if(matrix == null) {
            System.out.println("Not possible");
        } else {
            for(int i = 0; i < 2; i++) {
                for(int j =0 ; j < n;j++) {
                    System.out.print(matrix[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }

    private static int[][] findMatrix(int n, int u, int l, int[] c) {
        int[][] matrix = new int[2][n];

        for(int i = 0; i< n; i++) {
            if(c[i] == 2) {
                matrix[0][i] = 1;
                matrix[1][i] = 1;
                u--;
                l--;
            } else if(c[i] == 0) {
                matrix[0][i] = 0;
                matrix[1][i] = 0;
            } else {
                if(u > l) {
                    matrix[0][i] = 1;
                    u--;
                } else if(l > 0){
                    matrix[1][i] = 1;
                    l--;
                } else {
                    return null;
                }
            }
        }

        if(u != 0 || l != 0) {
            return null;
        }

        return matrix;
    }

}
