package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//https://leetcode.com/problems/minimum-window-substring/
// #TwoPointer, #SlidingWindow, #String
public class MinimumWindowSubstring {

    @SuppressWarnings("all")
    public String minWindow(String s, String t) {
        String ans = "";
        int minLength = s.length() + 1;
        Map<Integer, Long> targetCharCount = t.chars()
                .mapToObj(c -> c)
                .collect(Collectors.groupingBy(a -> a, Collectors.counting()));
        int left = 0;
        int required = targetCharCount.size();
        int formed = 0;
        Map<Integer, Long> windowCharCount = new HashMap<>();
        //move left to next until atleast a character from t is found
        left = moveLeft(s, targetCharCount, left);
        int right = left;
        int answerLeft = left, answerRight = right;
        while (right < s.length()) {
            int rightChar = s.charAt(right);
            if (targetCharCount.containsKey(rightChar)) {
                windowCharCount.put(rightChar, windowCharCount.getOrDefault(rightChar, 0L) + 1);
                if (windowCharCount.get(rightChar).equals(targetCharCount.get(rightChar))) {
                    formed++;
                }
                if (formed == required) {
                    if (minLength > right - left + 1) {
                        minLength = right - left + 1;
                        answerLeft = left;
                        answerRight = right;
                    }
                    formed = removeLeftElement(s, left, windowCharCount, targetCharCount, formed);
                    windowCharCount.put(rightChar, windowCharCount.get(rightChar) - 1);
                    if (rightChar != s.charAt(left)) formed--;
                    //move left to next known place where we can find a character from t
                    left = moveLeft(s, targetCharCount, left + 1);
                    continue;
                }
            } else if (minLength < right  - left + 1) {
                formed = removeLeftElement(s, left, windowCharCount, targetCharCount, formed);
                left = moveLeft(s, targetCharCount, left + 1);
                right = Math.max(right, left);
                continue;
            }
            right++;
        }
        return minLength == s.length() + 1 ? "" : s.substring(answerLeft, answerRight + 1);
    }

    private static int removeLeftElement(String s, int left, Map<Integer, Long> windowCharCount, Map<Integer, Long> targetCharCount, int formed) {
        int leftChar = s.charAt(left);
        if (windowCharCount.get(leftChar).equals(targetCharCount.get(leftChar))) {
            formed--;
        }
        windowCharCount.put(leftChar, windowCharCount.get(leftChar) - 1);
        return formed;
    }

    private int moveLeft(String s, Map<Integer, Long> targetCharCount, int left) {
        while (left < s.length()) {
            int character = s.charAt(left);
            if (targetCharCount.containsKey(character)) {
                break;
            }
            left++;
        }
        return left;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        System.out.println(obj.minWindow("wegdtzwabazduwwdysdetrrctotpcepalxdewzezbfewbabbseinxbqqplitpxtcwwhuyntbtzxwzyaufihclztckdwccpeyonumbpnuonsnnsjscrvpsqsftohvfnvtbphcgxyumqjzltspmphefzjypsvugqqjhzlnylhkdqmolggxvneaopadivzqnpzurmhpxqcaiqruwztroxtcnvhxqgndyozpcigzykbiaucyvwrjvknifufxducbkbsmlanllpunlyohwfsssiazeixhebipfcdqdrcqiwftutcrbxjthlulvttcvdtaiwqlnsdvqkrngvghupcbcwnaqiclnvnvtfihylcqwvderjllannflchdklqxidvbjdijrnbpkftbqgpttcagghkqucpcgmfrqqajdbynitrbzgwukyaqhmibpzfxmkoeaqnftnvegohfudbgbbyiqglhhqevcszdkokdbhjjvqqrvrxyvvgldtuljygmsircydhalrlgjeyfvxdstmfyhzjrxsfpcytabdcmwqvhuvmpssingpmnpvgmpletjzunewbamwiirwymqizwxlmojsbaehupiocnmenbcxjwujimthjtvvhenkettylcoppdveeycpuybekulvpgqzmgjrbdrmficwlxarxegrejvrejmvrfuenexojqdqyfmjeoacvjvzsrqycfuvmozzuypfpsvnzjxeazgvibubunzyuvugmvhguyojrlysvxwxxesfioiebidxdzfpumyon", "ozgzyywxvtublcl"));
        System.out.println(obj.minWindow("aaflslflsldkalskaaa", "aaa"));
        System.out.println(obj.minWindow("acbbaca", "aba"));
        System.out.println(obj.minWindow("acbbaba", "aba"));
        System.out.println(obj.minWindow("ADOBECODEBANCOOOOOOB", "ABC"));
        System.out.println(obj.minWindow("BBBBBBAC", "ABC"));
        System.out.println(obj.minWindow("BBBBBBAOCOOABCQQQQQA", "ABC"));
        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(obj.minWindow("a", "a"));
        System.out.println(obj.minWindow("a", "aa"));

    }
}
