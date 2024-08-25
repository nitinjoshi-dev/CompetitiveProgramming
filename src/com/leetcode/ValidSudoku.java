package com.leetcode;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/valid-sudoku/description/
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Set<String> sudokuMap = new HashSet<>(27);

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                char currentChar = board[row][column];
                if (currentChar != '.') {
                    if (!sudokuMap.add(currentChar + " in row " + row) ||
                            !sudokuMap.add(currentChar + " in column " + column) ||
                            !sudokuMap.add(currentChar + " in block " + (row / 3) + "," + (column / 3)))
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku obj = new ValidSudoku();
        System.out.println(obj.isValidSudoku(new char[][] {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));

        System.out.println(obj.isValidSudoku(new char[][] {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));

    }

}
