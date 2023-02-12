package com.leetcode;

//https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {


    public String longestCommonPrefix(String[] strs) {
        StringBuilder longestCommonPrefix = new StringBuilder(strs[0]);
        StringBuilder commonPrefix = new StringBuilder("");

        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            for (int j = 0; j < str.length() && j < longestCommonPrefix.length(); j++) {
                if(str.charAt(j) == longestCommonPrefix.charAt(j)) {
                    commonPrefix.append(str.charAt(j));
                } else {
                    break;
                }
            }
            longestCommonPrefix.setLength(0);
            longestCommonPrefix.append(commonPrefix);
            commonPrefix.setLength(0);
        }
        return longestCommonPrefix.toString();
    }

    public String longestCommonPrefixBetterSolution(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    public String longestCommonPrefixBetterSolution2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix(strs, l , mid);
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }


    public static void main(String[] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();

        String[] strs = {"flower","flow","flight"};
        System.out.println(obj.longestCommonPrefix(strs));

        String[] strs1 = {"dog","racecar","car"};
        System.out.println(obj.longestCommonPrefix(strs1));

        String[] strs2 = {"cir", "car"};
        System.out.println(obj.longestCommonPrefix(strs2));



    }
}
