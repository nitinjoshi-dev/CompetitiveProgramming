package com.leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle/
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>(numRows);
        List<Integer> row = new ArrayList<>(1);
        row.add(1);
        List<Integer> previousRow = row;
        rows.add(row);
        for (int i = 1; i < numRows; i++) {
            row = new ArrayList<>(i + 1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(previousRow.get(j - 1) + previousRow.get(j));
            }
            row.add(1);
            rows.add(row);
            previousRow = row;
        }
        return rows;
    }


    public static void main(String[] args) {
        PascalTriangle obj = new PascalTriangle();
        List<List<Integer>> rows = obj.generate(5);
        print(rows);

        System.out.println("---------------------");
        rows = obj.generate(2);
        print(rows);

        System.out.println("---------------------");
        rows = obj.generate(7);
        print(rows);
    }

    private static void print(List<List<Integer>> rows) {
        for (List<Integer> row : rows) {
            for (Integer column : row) {
                System.out.print(column);
            }
            System.out.println();
        }
    }


}
