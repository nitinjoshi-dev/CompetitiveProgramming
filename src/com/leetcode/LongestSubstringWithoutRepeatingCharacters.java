package com.leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
//#SlidingWindow, #TwoPointer
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int minIndex = 0;
        Map<Character, Integer> visitedMap = new HashMap<>(s.length());

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            Integer lastVisitedPosition = visitedMap.get(currentChar);
            if (lastVisitedPosition != null && minIndex <= lastVisitedPosition) {
                minIndex = lastVisitedPosition + 1;
            }
            visitedMap.put(currentChar, i);
            maxLength = Math.max(maxLength, i - minIndex + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();

        int ans = obj.lengthOfLongestSubstring("abcabcbb");
        System.out.println(ans);

        ans = obj.lengthOfLongestSubstring("bbbbb");
        System.out.println(ans);

        ans = obj.lengthOfLongestSubstring("pwwkew");
        System.out.println(ans);

        ans = obj.lengthOfLongestSubstring(" ");
        System.out.println(ans);

        ans = obj.lengthOfLongestSubstring("");
        System.out.println(ans);

        ans = obj.lengthOfLongestSubstring("dvdf");
        System.out.println(ans);

        ans = obj.lengthOfLongestSubstring("abcdefcbaxyzgh");
        System.out.println(ans);

        ans = obj.lengthOfLongestSubstring("bbtablud");
        System.out.println(ans);

    }
}
