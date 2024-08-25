package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/longest-consecutive-sequence/

/**
 * Approach taken is to keep track of the chain of elements that are part of the sequence.
 * For each element, we check if the element is already part of the sequence.
 * If not, we check if the element can be part of the sequence by checking the left and right elements.
 * If the left and right elements are part of the sequence, we update the chain of the current element.
 * We also update the chain of the left and right elements to point to the current left and right.
 * Time complexity of this is O(n)
 * Space complexity is O(n)
 * <p>
 * Other approach could have been to convert the list into hash set -> time: O(n)
 * After that for each element, we check if the element is the start of the sequence.
 * To check this we check if the element - 1 is present in the set. If not, that means it is start of sequence.
 * We start counting the sequence from there i.e. is element + 1, element + 2, element + 3 are present in the set.
 * And we update the length like that
 */
public class LongestConsecutiveSequence {

    class Chain {
        int left;
        int rigth;

        Chain(int left, int right) {
            this.left = left;
            this.rigth = right;
        }
    }


    public int longestConsecutive(int[] nums) {
        int length = 0;
        Map<Integer, Chain> elementToLengthMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!elementToLengthMap.containsKey(num)) {
                Chain leftChain = elementToLengthMap.getOrDefault(num - 1, new Chain(num, num));
                Chain rightChain = elementToLengthMap.getOrDefault(num + 1, new Chain(num, num));

                Chain newChain = new Chain(leftChain.left, rightChain.rigth);
                elementToLengthMap.put(num, newChain);
                if (leftChain.left != num) {
                    elementToLengthMap.put(leftChain.left, newChain);
                }
                if (rightChain.rigth != num) {
                    elementToLengthMap.put(rightChain.rigth, newChain);
                }
                length = Math.max(length, newChain.rigth - newChain.left + 1);
            }
        }
        return length;
    }

    public int longestConsecutive2(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        //Convert to set. Time Complexity -> O(n)
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;
        //Time Complexity -> O(n)
        for (int num : nums) {
            //check if it is start of sequence or not. Time Complexity -> O(1)
            if (!numSet.contains(num - 1)) {
                int length = 1;
                //Since it is start of sequence. check the length of the sequence.
                //happens only for start of sequence and nothing else. Time Complexity -> O(n)
                while (numSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
        System.out.println(obj.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(obj.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
}
