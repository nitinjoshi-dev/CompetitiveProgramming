package com.leetcode;

//https://leetcode.com/problems/permutation-in-string/description/
//#TwoPointer, #SlidingWindow, #String

/**
 * This is a sliding window problem. We need to find if a permutation of s1 is present in s2.
 * We select a window of size s1. and see if the two strings are anaagrams or not.
 * If not we slide the window to right by 1 and check again.
 * To efficiently check if the two strings are anagrams we can use an array of size 26 to keep count of each character in the string.
 * While moving the window we need to update the count of the characters in the window.
 * for left counter we are removing the chars so we check if removing it is making it anagram or not
 * for right counter we are adding the chars so we check if adding it is making it anagram or not
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1CharCount = new int[26];
        if (s1.length() > s2.length()) return false;
        int left = 0, right = s1.length() - 1;
        int[] s2WindowCharCount = new int[26];
        //counting initial s1 and s2 window chars
        for (int i = left; i <= right; i++) {
            s1CharCount[s1.charAt(i) - 'a']++;
            s2WindowCharCount[s2.charAt(i) - 'a']++;
        }
        int totalCharMatch = 0;
        //counting initial s1 and s2 window chars matches
        for (int i = 0; i < 26; i++) {
            if (s1CharCount[i] == s2WindowCharCount[i]) totalCharMatch++;
        }
        right++;
        while (right < s2.length()) {
            if (totalCharMatch == 26) return true;
            int rightChar = s2.charAt(right) - 'a';
            totalCharMatch = getTotalCharMatch(s1CharCount, rightChar, s2WindowCharCount, totalCharMatch, true);
            int leftChar = s2.charAt(left) - 'a';
            totalCharMatch = getTotalCharMatch(s1CharCount, leftChar, s2WindowCharCount, totalCharMatch, false);
            left++;
            right++;
        }
        return totalCharMatch == 26;
    }

    //This method is used to update the totalCharMatch count
    //This is used for left as well as right pointer
    //If shouldIncrease is true then we increase the count of the character in the window(i.e. a right pointer is incremented)
    //else we decrement the counter i.e. a left pointer is incremented and thus we are removing the character from the window
    private static int getTotalCharMatch(int[] s1CharCount, int character, int[] s2WindowCharCount,
                                         int totalCharMatch, boolean shouldIncrease) {
        if (s1CharCount[character] == s2WindowCharCount[character]) --totalCharMatch;
        if (shouldIncrease) s2WindowCharCount[character]++;
        else s2WindowCharCount[character]--;
        if (s1CharCount[character] == s2WindowCharCount[character]) ++totalCharMatch;
        return totalCharMatch;
    }

    public static void main(String[] args) {
        PermutationInString obj = new PermutationInString();
        System.out.println(obj.checkInclusion("ab", "ab"));
        System.out.println(obj.checkInclusion("ab", "eidbaooo"));
        System.out.println(obj.checkInclusion("ab", "eidboaoo"));
    }
}
