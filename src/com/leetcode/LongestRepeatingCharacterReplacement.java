package com.leetcode;

//https://leetcode.com/problems/longest-repeating-character-replacement/description/
//#SlidingWindow, #TwoPointer, #String
/**
 * Logic to find here is that as long as
 * substring length (i.e. right - left + 1) - maxFrequency of character in substring  <= k we can replace k characters
 * increment the right counter to increment the substring length.
 * when substring length - maxFrequency > k, we can't replace k characters then shift left to 1 position right
 * To calculate maxFrequency, we need to keep track of the max count of a character in the substring for this we will use array of size 26
 * When we shift the left pointer we reduce the count of the character at left pointer by 1 since we are removing that character from the substring
 * Ideally we should also re calculate the maxFrequency cause if the character at left was max count it might be impacted.
 * but for us to get better result than current result we need to minimize length - maxFrequency and maximize length as well
 * So that means we need to maximize the maxCount as well only then we can minimize the length - maxFrequency
 */
public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int[] charFrequency = new int[26];
        int left = 0, right = 0;
        int maxFrequency = 0;
        while(right < s.length()) {
            int currentChar = s.charAt(right) - 'A';
            charFrequency[currentChar]++;
            maxFrequency = Math.max(maxFrequency, charFrequency[currentChar]);
            if (right - left + 1 - maxFrequency > k) {
                //if this condition is not satisfied we will shift the left pointer to left + 1
                // also will reduce the left char frequency since we are removing the character at left
                charFrequency[s.charAt(left) - 'A']--;
                left++;
                //ideally we should also re calculate the maxFrequency cause if the character at left was max count it might be impacted
                //but for us to get better result than current result we need to minimize length - maxFrequency and maximize length as well
                //So that means we need to maximize the maxCount as well only then we can minimize the length - maxFrequency
                //so recalculating and decreasing the max count would not help.
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    //This is a brute force solution
    public int characterReplacement2(String s, int k) {
        int ans = 0;
        int left = 0, right = left + 1;
        int remainingReplacements = k;
        int firstReplacement = -1;
        while (left < s.length()) {
            char leftChar = s.charAt(left);
            while (right < s.length()) {
                if (s.charAt(right) != leftChar) {
                    if (remainingReplacements == 0) {
                        break;
                    }
                    if (firstReplacement == -1) {
                        firstReplacement = right;
                    }
                    remainingReplacements--;
                }
                right++;
            }
            ans = Math.max(ans, Math.min(s.length(), right - left + remainingReplacements));
            left = getNextLeftPointer(right, firstReplacement);
            right = left + 1;
            firstReplacement = -1;
            remainingReplacements = k;
        }
        return ans;
    }

    private int getNextLeftPointer(int right, int firstReplacement) {
        if (firstReplacement == -1) {
            return right;
        }
        return firstReplacement;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();
        int ans = obj.characterReplacement("ABAB", 2);
        System.out.println(ans);
        ans = obj.characterReplacement("AABABBA", 1);
        System.out.println(ans);
        ans = obj.characterReplacement("AABBABA", 1);
        System.out.println(ans);
        ans = obj.characterReplacement("AABBABAB", 2);
        System.out.println(ans);
        ans = obj.characterReplacement("AABBABAB", 0);
        System.out.println(ans);
        ans = obj.characterReplacement("AABBABAB", 0);
        System.out.println(ans);
        ans = obj.characterReplacement("ABBB", 2);
        System.out.println(ans);
    }


}
