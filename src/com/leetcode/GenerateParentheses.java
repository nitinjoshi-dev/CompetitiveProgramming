package com.leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/generate-parentheses/
//#Backtracking
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, 0, 0, "", result);
        return result;
    }

    private void generateParenthesis(int n, int open, int close, String str, List<String> result) {
        if (open == n && close == n) {
            result.add(str);
        }
        if (open < n) {
            generateParenthesis(n, open + 1, close, str + "(", result);
        }
        if (close < open) {
            generateParenthesis(n, open, close + 1, str + ")", result);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses obj = new GenerateParentheses();
        System.out.println(obj.generateParenthesis(3));
        System.out.println(obj.generateParenthesis(4));
        System.out.println(obj.generateParenthesis(8));
    }


}
