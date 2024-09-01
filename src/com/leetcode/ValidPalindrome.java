package com.leetcode;

//https://leetcode.com/problems/valid-palindrome/
//#TwoPointer, #String
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            while(left < right && !Character.isLetterOrDigit(leftChar)) {
                left++;
                leftChar = s.charAt(left);
            }
            char rightChar = s.charAt(right);
            while(left < right && !Character.isLetterOrDigit(rightChar)) {
                right--;
                rightChar = s.charAt(right);
            }
            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome obj = new ValidPalindrome();
        System.out.println(obj.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(obj.isPalindrome("Race a car"));
        System.out.println(obj.isPalindrome(" "));

    }
}
